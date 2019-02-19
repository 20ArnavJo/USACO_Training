package main;
import java.util.*;
import java.io.*;
import java.text.*;
public class Cipher {
    static final String base =  "😁";
    public static String removeslash (String s)
    {
        String c = "";
        for (int i = 0; i < s.length(); i++)
        {
            if (Character.toString(s.charAt(i)).equals("/") || Character.toString(s.charAt(i)).equals("0"))
            {
                continue;
            }
            c = c + s.charAt(i);
        }
        return c;
    }
    public static int bitShift(char c, int bits)
    {
        int h = (int) c;
        bits %= 8;
        int k = h/((int) Math.pow(2, 8 - bits));
        h = h % (int) Math.pow(2, 8 - bits);
        h *= (int) Math.pow(2, bits);
        h += k;
        return h;
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        String temp = sc.next();
        if(temp.equals("encrypt")) {
            char arrlow[] = new char[33];
            char arrhigh[] = new char[33];
            for (int i = 0; i < 33; i++) {
                arrlow[i] = (char) (128768 + i);
                arrhigh[i] = (char) (942 + i);
                if (i == 32) {
                    arrlow[i] = (char) 128842;
                }
            }
            DateFormat df = new SimpleDateFormat("HH");
            Date dateobj = new Date();
            DateFormat df2 = new SimpleDateFormat("dd/MM/yyyy");
            int hour = Integer.parseInt(df.format(dateobj));
            String key = df2.format(dateobj);
            key = removeslash(key);
            int curr = 0;
            while (true) {
                String s = sc.next();
                if (s.equals("end")) {
                    break;
                }
                String c = "";
                for (int i = 0; i < s.length(); i++) {
                    int f = bitShift(s.charAt(i), hour % 8);
                    if ((int) hour / 12 == 0) {
                        f = (f ^ ((int) key.charAt(i % key.length()) - 48 + curr));
                    } else {
                        f = (f ^ ((int) key.charAt(i % key.length()) - 48 + curr));
                    }
                    f += 256;
                    f %= 256;
                    if (f % 128 < 33) {
                        if (f < 33) {
                            c = c + arrlow[f % 128];
                        } else {
                            c = c + arrhigh[f % 128];
                        }
                        curr = (curr + i) % key.length();
                        continue;
                    }
                    int a = (int) f;
                    a+= (int) base.charAt(0);
                    a%=128;
                    //f = a;
                    c = c + (char) f;
                    curr = (curr + i) % key.length();
                }
                System.out.print(c + " ");

            }
        }
            if(temp.equals("decrypt")){
                while (true)
                {
                    char arrlow[] = new char[33];
                    char arrhigh[] = new char[33];
                    for (int i = 0; i < 33; i++) {
                        arrlow[i] = (char) (128768 + i);
                        arrhigh[i] = (char) (942 + i);
                        if (i == 32) {
                            arrlow[i] = (char) 128842;
                        }
                    }
                    DateFormat df = new SimpleDateFormat("HH");
                    Date dateobj = new Date();
                    DateFormat df2 = new SimpleDateFormat("dd/MM/yyyy");
                    int hour = Integer.parseInt(df.format(dateobj));
                    String key = df2.format(dateobj);
                    key = removeslash(key);
                    int curr = 0;
                    String s = sc.next();
                    if (s.equals("end"))
                    {
                        break;
                    }
                    String c = "";
                    for (int i = 0; i < s.length(); i++)
                    {
                        int f = (int) s.charAt(i);
                        if ((int) hour/12 == 0)
                        {
                            f = (f ^ ((int) key.charAt(i % key.length()) - 48 + curr));
                        } else
                        {
                            f = (f ^ ((int) key.charAt(i % key.length()) - 48 + curr));
                        }
                        f = reverseBitShift(s.charAt(i), hour % 8);
                        f += 256;
                        f %= 256;
                        if (f % 128 < 33)
                        {
                            if (f < 33)
                            {
                                c = c + arrlow[f % 128];
                            } else
                            {
                                c = c + arrhigh[f % 128];
                            }
                            curr = (curr + i) % key.length();
                            continue;
                        }

                        c  = c + (char) f;
                        curr = (curr + i) % key.length();
                    }



                    System.out.print(c + " ");
                    String test  = "\uD83C\uDDF3\uD83C\uDDEA\uD83C\uDDF0\uD83C\uDDF2☪";
                }

            }

        }

    //shifts the thing forward
    public static int reverseBitShift(char c, int bits){
     int h = (int) c;
     h %= Math.pow(2,8);
     String s = Integer.toBinaryString(h);
     while(s.length() < 8){
         s  = '0' + s;
     }
     String temp = s.substring(s.length() - bits, s.length());
     h = h >> bits;
     for(int i = 0; i <  temp.length(); i++){
         h += Integer.parseInt(temp.substring(i,i+1)) * Math.pow(2, s.length() - 1 - i);
     }
     return h;
    }
}

package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class msquare {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        String temp = "";
        for(int i  = 0; i<8; i++){
            temp += st.nextToken();
        }
        int fin = Integer.parseInt(temp.substring(0,4) + temp.substring(7,8) + temp.substring(6,7)+ temp.substring(5,6) + temp.substring(4,5) );
        ArrayList<Integer> first = new ArrayList<Integer>();
        first.add(12348765);
        ArrayList<Integer> second = new ArrayList<Integer>();
        second.add(0);
        int pointer = 0;
        int currlen = 1;
        int ans = -1;
        while(ans == -1){
            for(int k = pointer; k< pointer + currlen; k++){
                for(int i = 1; i<=3; i++){
                    String temp4 = Integer.toString(second.get(k));
                    int temp5 = temp4.length();
                    if(temp5 == 1 || temp5 %10 != 0){
                        second.add(second.get(k) * 10 + i);
                    }
                    else {
                        second.add(second.get(k) + i);
                    }
                    int temp3 = 0;
                    if(i ==1){
                        temp3 = convertA(first.get(k));
                    }
                    if(i ==2){
                        temp3 = convertB(first.get(k));
                    }
                    if(i ==3){
                        temp3 = convertC(first.get(k));
                    }
                    if(!first.contains(temp3)){
                        first.add(temp3);
                    }
                    else {
                        second.remove(second.size() - 1);
                    }
                    if(temp3 == fin && ans == -1){
                        ans = second.get(second.size()  - 1);
                    }


                }
            }

            pointer = pointer + currlen;
            currlen *= 3;
        }
        if(fin == 12348765){
            System.out.println("0");
        }
        else {
            String gl = Integer.toString(ans);
            System.out.println(gl.length());
            String realAns = "";
            for (int i = 0; i < gl.length(); i++) {
                if (gl.substring(i, i + 1).equals("1")) {
                    realAns += "A";
                }
                if (gl.substring(i, i + 1).equals("2")) {
                    realAns += "B";
                }
                if (gl.substring(i, i + 1).equals("3")) {
                    realAns += "C";
                }
            }
            System.out.println(realAns);
        }


    }
    static int convertA(int curr){
        String temp = Integer.toString(curr);
        String temp1 = temp.substring(0,4);
        String temp2 = temp.substring(4,8);
        return Integer.parseInt(temp2 + temp1);
    }
    static int convertB(int curr){
        String temp = Integer.toString(curr);
        String temp1 = temp.substring(0,3);
        String temp2 = temp.substring(3,4) + temp1;
        String temp3 = temp.substring(7,8) + temp.substring(4,7);
        return Integer.parseInt(temp2 + temp3);
    }
    static int convertC(int curr){
        String temp = Integer.toString(curr);
        String temp2 = temp.substring(0,1) + temp.substring(5,6) +  temp.substring(1,2) + temp.substring(3,4);
        String temp3 = temp.substring(4,5) + temp.substring(6,7) +temp.substring(2,3) + temp.substring(7,8);

        return Integer.parseInt(temp2 + temp3);
    }
}

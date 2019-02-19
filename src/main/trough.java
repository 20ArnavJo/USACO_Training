package main;
import java.io.*;
import java.util.*;
public class trough {
    public static void main(String[] args) throws IOException{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int l = ((int)Math.pow(2,n));
        boolean[] possible = new boolean[l];
        for(int i = 0; i<l; i++){
            possible[i] = true;
        }
        int[][] values = new int[2][m];
        ArrayList<Integer> correct = new ArrayList<Integer>();
        for(int i = 0; i<m; i++){
            st = new StringTokenizer(input.readLine());
            String temp =  st.nextToken();
            int val = Integer.parseInt(st.nextToken());
            values[1][i] = val;
            int a = temp.length();
            int value = 0;
            for(int j = 0; j<temp.length(); j++){
                value += (Integer.parseInt(temp.substring(j, j+1)) * Math.pow(2, a - 1 - j));

            }
            values[0][i] = value;

        }
        for(int i = 0; i<possible.length; i++){
            for(int j = 0; j<values[0].length; j++){
                int temp = i & values[0][j];
                String str = Integer.toBinaryString(temp);
                int ans = 0;
                for(int k = 0; k<str.length(); k++){
                    if(str.substring(k, k+1).equals("1")){
                        ans++;
                    }
                }
                if(ans != values[1][j])
                {
                    possible[i] = false;
                    break;
                }


            }
            if(possible[i]){
                correct.add(i);
            }

        }
        if(correct.size() == 0){
            System.out.println("IMPOSSIBLE");
        }
        else if(correct.size() > 1){
            System.out.println("NOT UNIQUE");
        }
        else {
            System.out.println(Integer.toBinaryString(correct.get(0)));
        }


    }
}

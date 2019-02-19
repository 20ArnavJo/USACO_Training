package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class ttravel {
    public static void main(String[] args) throws IOException{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[] cows = new int[n +1];
        int[] prev = new int[n+1];
        cows[0] = -1;
        for (int i = 1; i <= n; i++){
            st = new StringTokenizer(input.readLine());
            String a = st.nextToken();
            if(a.equals("a")){
                cows[i] = Integer.parseInt(st.nextToken());
                prev[i] = i-1;
                System.out.println(cows[i]);

            }
            else if(a.equals("s")){
                cows[i] = cows[prev[i-1]];
                prev[i] = prev[prev[i-1]];
                System.out.println(cows[i]);


            }
            else if(a.equals("t")){
                int k = Integer.parseInt(st.nextToken());
                cows[i] = cows[k-1];
                prev[i] = prev[k-1];
                System.out.println(cows[i]);
            }

        }
    }
}

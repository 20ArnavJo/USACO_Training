package main;

import java.io.*;
import java.util.*;

public class mowlawn {
static long[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        long[] vals = new long[n];
        long[][] dp = new long[2][k + 1];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(input.readLine());
            vals[i] = Integer.parseInt(st.nextToken());

        }
        dp[0][1] = vals[0];

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < k + 1; j++) {

                if(j == 0){
                    arr = dp[0];
                    dp[1][j] = findMax();
                }
                else {
                    dp[1][j] = Math.max(dp[0][j], dp[0][j-1] + vals[i]);
                }

            }
            dp[0] = dp[1];
            dp[1] = new long[k+1];
        }
        arr = dp[0];
        System.out.println(findMax());



    }
    static long findMax(){
        long max = Long.MIN_VALUE;
        for(int i = 0; i<arr.length; i++){
            if(arr[i] > max){
                max = arr[i];
            }
        }
        return max;
    }



}

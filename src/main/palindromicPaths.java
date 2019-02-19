package main;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.*;
import java.util.*;

public class palindromicPaths {
    public static void main(String[] args)throws IOException{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        int n = Integer.parseInt(st.nextToken());
        String[][] area = new String[n][n];
        for(int i = 0; i<n; i++){
            st = new StringTokenizer(input.readLine());
            String temp =  st.nextToken();
            for(int j = 0; j<n; j++){

                area[i][j] = temp.substring(j, j+1);
            }
        }
        int[][] dp = new int[n][n];
        dp[0][0]  = 1;
        dp[n-1][n-1] = 1;
        if(area[0][0].equals(area[n-1][n-1])) {
            for (int i = 0; i < n/2; i++) {
                for (int j = 0; j < n/2; j++) {
                     if(area[i + 1][j].equals(area[n-2 - i][n-1 - j]) || area[i + 1][j].equals(area[n-1 - i][n-2-j])){
                        dp[i+1][j] += dp[i][j];

                     }
                    if(area[i][j + 1].equals(area[n-2 - i][n-1 - j]) || area[i][j + 1].equals(area[n-1 - i][n-2-j])){
                        dp[i][j + 1] += dp[i][j];
                    }
                }
            }
            for(int i = n/2; i<n; i++){
                for(int j = n/2; j<n; j++){
                    dp[i][j] += dp[i - 1][j];
                    dp[i][j] += dp[i][j-1];
                }
            }
            System.out.println(dp[n-1][n-1]);
        }
        else {
            System.out.println("0");
        }
    }
}

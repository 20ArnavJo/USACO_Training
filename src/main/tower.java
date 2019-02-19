package main;
import java.io.*;
import java.util.*;
public class tower {
    public static void main(String[] args) throws IOException{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[] w = new int[n];
        int[][] dp = new int[2][n];
        int[] width = new int[n];
        for(int i = 0; i<n; i++){
            st = new StringTokenizer(input.readLine());
            w[i] = Integer.parseInt(st.nextToken());
        }
        dp[0][0] = 1;
        width[1] = w[0];
        dp[1][0] = 1;
        width[0] = Integer.MAX_VALUE;
        //need to use two width arrays for the two things it could end in
        for(int i = 1; i<n; i++){
            if(width[dp[0][i-1]] + width[i] <= width[dp[0][i-1] - 1] && width[dp[1][i-1]] + width[i] <= width[dp[1][i-1] - 1])
            {
                dp[0][i] = Math.max(dp[0][i-1], dp[1][i-1]);
            if(dp[0][i-1]> dp[1][i-1]){
                width[dp[0][i]] = width[dp[0][i-1]] +  w[i];
            }
            else {
                width[dp[0][i]] = width[dp[1][i-1]] + w[i];
            }
            }
            else if(width[dp[0][i-1]] + width[i] <= width[dp[0][i-1] - 1])
            {
                dp[0][i] = dp[0][i-1];
                width[dp[0][i]] = width[dp[0][i-1]] + w[i];
            }
            else if(width[dp[1][i-1]] + width[i] <= width[dp[1][i-1] - 1])
            {
                dp[0][i] = dp[1][i-1];
                width[dp[0][i]] = width[dp[1][i-1]] + w[i];
            }
            if(w[i] <= width[dp[0][i-1]] && w[i] <= width[dp[1][i-1]]){
                dp[1][i] = 1 + Math.max(dp[0][i-1], dp[1][i-1]);
                width[dp[1][i]] = w[i];
            }
            else if(w[i] <= width[dp[0][i-1]]){
                dp[1][i] = 1 + dp[0][i-1];
                width[dp[1][i]] = w[i];
            }
            else if(w[i] <= width[dp[1][i-1]]){
                dp[1][i] = 1 + dp[1][i-1];
                width[dp[1][i]] = w[i];
            }


        }

    }
}

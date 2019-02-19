package main;
import java.io.*;
import java.util.*;
public class fewcoins {
    public static void main(String[] args)throws IOException{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        int n = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        int[][] coins = new int[2][n];
        st = new StringTokenizer(input.readLine());
        for(int i = 0; i<n; i++){
            coins[0][i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(input.readLine());
        for(int i = 0; i<n; i++){
            coins[1][i] = Integer.parseInt(st.nextToken());
        }
        int[] dp = new int[2 * t + 1];
        for(int i = 0; i<dp.length; i++){
            dp[i] = Integer.MAX_VALUE;
        }
        dp[0] = 0;
        for(int i = 0; i<n; i++){
            for(int j = 0; j<coins[1][i]; j++){
                for(int k = 2*t; k>=0; k--){
                    if(k - coins[0][i] >= 0 && dp[k - coins[0][i] ] != Integer.MAX_VALUE){
                        dp[k] = Math.min(dp[k], dp[k -coins[0][i]] + 1);

                    }

                }
            }
        }
        for(int i = 0; i<n; i++){
            for(int j = 2*t; j>=0; j--){
                if(dp[j] != Integer.MAX_VALUE && j - coins[0][i] >= 0){
                    dp[j-coins[0][i]] = Math.min(dp[j-coins[0][i]], dp[j] + 1);

                }
            }
        }
        if(dp[t] != Integer.MAX_VALUE){System.out.println(dp[t]);}
        else {System.out.println("-1");}


    }
}

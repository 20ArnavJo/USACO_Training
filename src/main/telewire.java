package main;
import java.io.*;
import java.util.*;
public class telewire {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        int n = Integer.parseInt(st.nextToken());
        long c = Integer.parseInt(st.nextToken());
        int[] height = new int[n];
        for(int i = 0; i<n; i++){
            st = new StringTokenizer(input.readLine());
            height[i] = Integer.parseInt(st.nextToken());
        }
        long[][] dp = new long[n][101];
        for(int i = 0; i<n; i++){
            for(int j = 0; j<=100; j++)
            {
                dp[i][j] = Long.MAX_VALUE;
            }
        }
        for(int i = 0; i<=100; i++){
            if(height[0] <= i){
                dp[0][i] = (long) Math.pow(i-height[0], 2);
            }
        }
        for(int i = 1; i<n; i++){
            for(int j = 0; j<=100; j++){
                if(j >= height[i]){
                    long temp = findMin(dp[i-1], j, c) + (long) Math.pow(j - height[i], 2);
                    if(temp >= 0){
                        dp[i][j] = temp;
                    }

                }
            }
        }
        long ans = Long.MAX_VALUE;
        for(int i = 0; i<=100; i++){
            if(dp[n-1][i]  < ans){
                ans = dp[n-1][i];
            }
        }
        System.out.println(ans);


    }
    static long findMin(long[] arr, long n, long c){
        long min = Long.MAX_VALUE;
        for(int i = 0; i<arr.length; i++){
            if((arr[i] != Long.MAX_VALUE && ((long)(arr[i] + c*Math.abs(n-i))) > 0 ) && ((long)(arr[i] + c*Math.abs(n-i)))  < min){
               min = ((long)(arr[i] + c*Math.abs(n-i))) ;
            }
        }
        return min;
    }
}

package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class guardMark {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        int n = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        int[][] dp = new int[(int)Math.pow(2,n) + 1][n];
        int[][] cows = new int[3][n];
        int[][] dpS = new int[(int)Math.pow(2,n) + 1][n];
        for(int i = 0; i<n; i++){
            st = new StringTokenizer(input.readLine());
            cows[0][i] = Integer.parseInt(st.nextToken());
            cows[1][i] = Integer.parseInt(st.nextToken());
            cows[2][i] = Integer.parseInt(st.nextToken());
        }
        for(int i = 0; i<n; i++){
            dpS[0][i] = Integer.MAX_VALUE;
        }
        for(int i = 1; i<Math.pow(2,n); i++){
                for(int k = 0; k<n; k++){
                    int temp = i&(int)Math.pow(2,k);
                    if(temp!= 0) {
                        int pointer = temp;
                        int c = -1;
                        for (int l = 0; l < n; l++) {
                            pointer = temp >> l;
                            if (pointer % 2 == 1) {
                                c = n - l - 1;
                            }
                        }
                        int[] a = findMax(dp[i - temp], cows[1][c], dpS[i - temp]);
                        int index = a[0];
                        int max = a[1];
                        if (max + cows[0][c] > dp[i][c]) {
                            dpS[i][c] = Math.min(dpS[i - temp][index] - cows[2][c], cows[2][c]);
                            dp[i][c] = max + cows[0][c];

                        }
                    }
                }
        }
        int ans = Integer.MIN_VALUE;
        for(int i = 0; i<Math.pow(2,n); i++){
            for(int j = 0; j<n; j++){
                if(dp[i][j] >= h && dpS[i][j] >ans){
                    ans = dpS[i][j];
                }
            }
        }
        System.out.println(ans);


    }
    static int[] findMax(int[] arr, int weight, int[] strength){
        int max = Integer.MIN_VALUE;
        int index = -1;
        for(int i = 0; i<arr.length; i++){
            if(strength[i]>=weight && arr[i] > max){
                max = arr[i];
                index = i;
            }
        }
        int[] temp = {index, max};
        return temp;

    }
}

package main;

public class Hi {
    public static void main(String[] args){
        int[][][][] dp = new int[2018][2018][2018][3]; // using i red, j blue, k green, with the last one being r,g,b
        dp[1][0][0][0] = 1;
        dp[0][1][0][1] = 1;
        dp[0][0][1][2] = 1;
        for (int i = 0; i <= 2017; i++) {
            for (int j = 0; j <= 2017; j++) {
                for (int k = 0; k <= 2017; k++) {
                    if (i != 0) {
                        dp[i][j][k][0] += dp[i - 1][j][k][0] + dp[i - 1][j][k][1];
                    }
                    if (j != 0) {
                        dp[i][j][k][1] += dp[i][j - 1][k][0] + dp[i][j - 1][k][2];
                    }
                    if (k != 0) {
                        dp[i][j][k][2] += dp[i][j][k - 1][1] + dp[i][j][k - 1][2];
                    }
                }
            }
        }
        int ans = dp[2017][2017][2017][0] + dp[2017][2017][2017][1] + dp[2017][2017][2017][2];
        System.out.println(ans);
    }
}

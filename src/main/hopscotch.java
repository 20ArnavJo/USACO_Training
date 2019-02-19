
import java.io.BufferedReader;
import java.io.*;
import java.util.*;

public class hopscotch {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader("hopscotch.in"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("hopscotch.out")));
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] original = new int[r][c];
        for(int i = 0; i<r; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<c; j++){
                original[i][j] = Integer.parseInt(st.nextToken());

            }
        }
        int[][] dp = new int[r][c];
        dp[0][0] = 1;

        for(int i = 0; i<r; i++){
            for(int j = 0; j<c; j++){
                for(int m = i + 1; m<r; m++){
                    for(int n = j+1; n<c; n++){
                        if(original[i][j] != original[m][n]){
                            dp[i][j] %= 1000000007;
                            dp[m][n] += dp[i][j];
                            dp[m][n] %= 1000000007;
                        }
                    }
                }
            }
        }
        pw.print(dp[r-1][c-1]);
        pw.close();
    }
}

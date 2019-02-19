package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class castle {
    static int[][] available;
    static int[][] castle;

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        castle = new int[m][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(input.readLine());
            for (int j = 0; j < m; j++) {
                castle[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        available = new int[m][n];


    }

    static int floodfill(int i, int j) {
        int temp = castle[i][j];
        String a = Integer.toBinaryString(temp);
        for (int k = 0; k < 4; k++) {
            if (a.substring(k, k + 1).equals("0")) {
                if (k == 0) {

                }
            }


        }
        return 0;
    }
}

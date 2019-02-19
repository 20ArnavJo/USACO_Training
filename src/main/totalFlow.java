package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class totalFlow {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[][] adjmatrix = new int[53][53];
        double[] value = new double[53];
        for(int i = 0; i<n; i++){
            st = new StringTokenizer(input.readLine());
            String temp = st.nextToken();
            char[] temp1  = temp.toCharArray();
            char temp2 = temp1[0];
            int u = temp2 - 64;
            if(u > 26){
                u = temp2 - 70;

            }
            String temp3 = st.nextToken();
            char[] temp4  = temp3.toCharArray();
            char temp5 = temp4[0];
            int v = temp5 - 64;
            if(v > 26){
                v = temp5 - 70;

            }
            adjmatrix[u][v] = Integer.parseInt(st.nextToken());
            adjmatrix[v][u] = adjmatrix[u][v];

        }
        Queue<Integer> q = new LinkedList<Integer>();
        value[1] = 100000;



    }

}

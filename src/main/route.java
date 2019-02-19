package main;

import java.io.*;
import java.util.*;

public class route {
    public static void main(String[] args) throws IOException{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int[] left = new int[n+1];
        int[] right = new int[m+1];
        ArrayList<Integer>[] adjListLeft = new ArrayList[n + 1];
        ArrayList<Integer>[] adjListRight = new ArrayList[m + 1];
        //int[][]  distToDown = new int[]
        for(int i = 0; i<n; i++){
            st = new StringTokenizer(input.readLine());
            left[i+1] = Integer.parseInt(st.nextToken());
        }
        for(int i = 0; i<m; i++){
            st = new StringTokenizer(input.readLine());
            right[i+1] = Integer.parseInt(st.nextToken());
        }


    }
}

package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Tractor2 {
    static int[][] elevations;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        int n = Integer.parseInt(st.nextToken());
        elevations = new int[n][n];
        for(int i = 0; i<n; i++){
            st = new StringTokenizer(input.readLine());
            for(int j = 0; j<n; j++){
                elevations[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int low = 0;
        int high = 1000000;
        int mid = 500000;
        while(function(mid) && !function(mid - 1)){
            if(!function(mid)){
                low = mid + 1;
                mid = (low + high)/2;
            }
            if(function(mid)){
                high = low - 1;
                mid = (low + high)/2;
            }

        }
    }
    static boolean function(int d){
        return false;
                //random

    }
}

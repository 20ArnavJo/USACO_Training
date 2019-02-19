package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class tractor {
    static int[][] area;
    static boolean[][] bales;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        area = new int[10][10];
        for(int i = 0; i<10; i++){
            for(int j = 0; j<10; j++){
                area[i][j] = Integer.MAX_VALUE;
            }
        }
        bales = new boolean[10][10];
        visited = new boolean[10][10];
        for(int i = 0; i<n; i++){
            st = new StringTokenizer(input.readLine());
            bales[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = true;
        }
        findVals(x,y,0);
        System.out.println(area[0][0]);
    }
    static void findVals(int x, int y, int curr){
        visited[x][y] = true;
        if(area[x][y] > curr){
            area[x][y] = curr;
            if(bales[x][y]){
                area[x][y]++;
            }
        }

        if(validPoint(x + 1,y) && !visited[x + 1][y]){
            findVals(x + 1, y, area[x][y]);

        }
        if(validPoint(x - 1,y)&& !visited[x - 1][y]){
            findVals(x - 1, y, area[x][y]);

        }
        if(!validPoint(x ,y + 1) && visited[x][y + 1]){
            findVals(x , y + 1, area[x][y]);

        }
        if(validPoint(x,y - 1)&& !visited[x][y - 1]){
            findVals(x, y - 1, area[x][y]);

        }


    }
    static boolean validPoint(int x, int y){
        if(x < 0 ){
            return false;
        }
        if(x >= 10){
            return false;
        }
        if(y < 0 ){
            return false;
        }
        if(y >= 10){
            return false;
        }
        return true;
    }
}

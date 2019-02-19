package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class ccski {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        boolean[][] visited = new boolean[m][n];
        int[][] values = new int[m][n];
        int[][] waypoints = new int[m][n];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(input.readLine());
            for (int j = 0; j < n; j++) {
                values[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(input.readLine());
            for (int j = 0; j < n; j++) {
                waypoints[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int a = 0;
        int b = 0;
        ArrayList<Pairs> pairs = new ArrayList<Pairs>();
        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                if(waypoints[i][j] == 1){
                    a = i;
                    b = j;
                    pairs.add(new Pairs(i,j));
                }

            }
        }

        int mid = 500000000;
        int low = 0;
        int high = 1000000000;
        visited = run(visited,a,b,values,mid, m, n);
        while(true){
            if(checked(pairs,visited)){
                mid = (low + high)/2;
                high = mid - 1;
            }


        }



    }
    public static boolean[][] run(boolean[][] visited, int a, int b, int[][] values, int d, int m, int n){
        Queue<Pairs> bfs = new LinkedList<Pairs>();
        bfs.add(new Pairs(a,b));
        while (!bfs.isEmpty()){
            Pairs temp = bfs.remove();
            visited[temp.x][temp.y] = true;
            if(temp.x - 1 >= 0 && Math.abs(values[temp.x - 1][temp.y] -values[temp.x][temp.y]) < d ){
                bfs.add(new Pairs(temp.x-1, temp.y));
                visited[temp.x - 1][temp.y] = true;
            }
            if(temp.y - 1>= 0 && Math.abs(values[temp.x][temp.y - 1] -values[temp.x][temp.y]) < d ){
                bfs.add(new Pairs(temp.x, temp.y - 1));
                visited[temp.x][temp.y - 1] = true;
            }
            if(temp.x + 1 < m && Math.abs(values[temp.x + 1][temp.y] -values[temp.x][temp.y]) < d ){
                bfs.add(new Pairs(temp.x+1, temp.y));
                visited[temp.x + 1][temp.y] = true;
            }
            if(temp.y + 1 < n && Math.abs(values[temp.x ][temp.y +1] -values[temp.x][temp.y]) < d ){
                bfs.add(new Pairs(temp.x, temp.y + 1));
                visited[temp.x][temp.y + 1] = true;
            }
        }
        return visited;
    }
    public static boolean checked(ArrayList<Pairs> pairs, boolean[][] visited){
        boolean fin = true;
        for(int i = 0; i<pairs.size(); i++){
            Pairs temp = pairs.get(i);
            if(!visited[temp.x][temp.y]){
                fin = false;
            }
        }
        return fin;
    }
}
class Pairs{
    int x;
    int y;
    public Pairs(int x, int y){
        this.x = x;
        this.y = y;
    }
}

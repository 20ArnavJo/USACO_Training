package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class cruise {
    static int[] path;
    static int[][] destination;
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] findestination = new int[n + 1];
        destination = new int[2][n + 1];
        for(int i = 1; i<=n; i++){
            st = new StringTokenizer(input.readLine());
            destination[0][i] = Integer.parseInt(st.nextToken());
            destination[1][i] = Integer.parseInt(st.nextToken());
        }
        path = new int[m];
        st = new StringTokenizer(input.readLine());
        for(int i = 0; i<m; i++){
            String temp = st.nextToken();
            if(temp.equals("L"))
            {
                path[i] = 0;
            }
            if(temp.equals("R"))
            {
                path[i] = 1;
            }
        }
        boolean[] visited = new boolean[n+1];
        int curr = 1;

        for(int i = 0; i<k; i++){
            visited[curr] = true;

            if(findestination[curr] == 0){
                int temp = curr;
                curr = path(curr);
                findestination[temp] = curr;
            }
            else {
                curr = findestination[curr];
            }
        }
        System.out.println(curr);

    }
    static int path(int start){
        int fin = start;
        for(int i = 0; i<path.length; i++){
            fin = destination[path[i]][fin];
        }
        return fin;
    }
}

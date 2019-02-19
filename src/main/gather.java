package main;

import java.io.*;
import java.util.*;

public class gather {
static int[][] adjMatrix;
static int total = 0;
static int answer = Integer.MAX_VALUE;
static int n;
static int[] cows;
static int start;
    public static void main(String[] args) throws IOException{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        n = Integer.parseInt(st.nextToken());
        cows = new int[n + 1];
        adjMatrix = new int[n+1][n+1];

        for(int i = 1; i<n + 1; i++){
            st = new StringTokenizer(input.readLine());
            cows[i] = Integer.parseInt(st.nextToken());
        }
        for(int i = 1; i<n; i++)
        {
            st = new StringTokenizer(input.readLine());
            int temp = Integer.parseInt(st.nextToken());
            int temp1 = Integer.parseInt(st.nextToken());
            int temp2 = Integer.parseInt(st.nextToken());
            adjMatrix[temp][temp1] = temp2;
            adjMatrix[temp1][temp] = temp2;
        }
        for(int i = 1; i<n+1; i++){
            start = i;
            DFS(i);
            if (total < answer){total = answer;}
            total = 0;
        }
        System.out.println(total);
    }
    static void DFSUtil(int v,boolean visited[])
    {

        visited[v] = true;
        total += cows[v] * adjMatrix[start][v];
        ArrayList<Integer> temp = new ArrayList<Integer>(adjMatrix[v].length);
        for(int i = 0; i< adjMatrix[v].length; i++){
            temp.add(i,adjMatrix[v][i]);
        }
        Iterator<Integer> i = temp.listIterator();
        while (i.hasNext())
        {
            int n = i.next();
            if (!visited[n])
                DFSUtil(n, visited);
        }
    }


    static void DFS(int v)
    {
        boolean visited[] = new boolean[n + 1];


        DFSUtil(v, visited);
    }
}

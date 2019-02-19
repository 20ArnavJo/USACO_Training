package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Prims {
    static int[][] adjMatrix;
    static int n;
    static int[] distTo;
    public static void main(String[] args) throws IOException{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        n = Integer.parseInt(st.nextToken()); // number of verticies
        int e =Integer.parseInt(st.nextToken()); // number of edges
        adjMatrix = new int[n+1][n+1];
        for(int i = 0; i<e; i++){
            st = new StringTokenizer(input.readLine());
            int temp1 = Integer.parseInt(st.nextToken());
            int temp2 = Integer.parseInt(st.nextToken());
            int temp3 = Integer.parseInt(st.nextToken());
            adjMatrix[temp1][temp2] = temp3;
            adjMatrix[temp2][temp1] = temp3;


        }
        distTo = new int[n+1];
        for(int i  = 2; i<distTo.length; i++){
            distTo[i] = Integer.MAX_VALUE;
        }
        System.out.println(prim());


    }
    public static int prim(){
        int total = 0;
        boolean[] visited = new boolean[n+1];
        Queue<Vertex> pq = new PriorityQueue<Vertex>();
        pq.add(new Vertex(1, 0 ));
        while (!pq.isEmpty()){
            Vertex temp = pq.remove();
            visited[temp.node] = true;
            total += temp.distance;
            int[] temp1 = adjMatrix[temp.node];
            for(int i = 0; i<temp1.length; i++){
                if(temp1[i] != 0 && temp1[i] <= distTo[i]){

                }
            }
        }
        return 0;

    }

}

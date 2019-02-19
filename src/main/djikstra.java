package main;



import java.io.*;
import java.util.*;
public class djikstra {
    // Djikstra is based fully on one-based indexing of nodes
    static int[][] adjMatrix;
    static int n;
    static int[] distTo;
    public static void main(String[] args) throws IOException{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        n = Integer.parseInt(st.nextToken()); //number of verticies
        int e = Integer.parseInt(st.nextToken()); //number of edges (undirected, change for to get directed)
        int a = Integer.parseInt(st.nextToken()); // starting vertex
        int b = Integer.parseInt(st.nextToken()); // ending vertex
        adjMatrix = new int[n+1][n+1];
        for(int i = 0; i<e; i++){
            st = new StringTokenizer(input.readLine());
            int temp = Integer.parseInt(st.nextToken());
            int temp1 = Integer.parseInt(st.nextToken());
            int temp2 = Integer.parseInt(st.nextToken());
            adjMatrix[temp][temp1] = temp2;
            adjMatrix[temp1][temp] = temp2;
        }
        distTo = new int[n+1];
        for(int i = 0; i<n + 1; i++){
            distTo[i] = Integer.MAX_VALUE;
        }
        djikstra(a);
        System.out.println(distTo[b]);


    }
    public static void djikstra(int start){
        Queue<Vertex> pq = new PriorityQueue<Vertex>();
        pq.add(new Vertex(start, 0));
        boolean[] visited = new boolean[n+1];
        distTo[start] = 0;
        while(!pq.isEmpty()){
            Vertex temp = pq.remove();
            int[] children = adjMatrix[temp.node];
            int node = temp.node;
            int distance = temp.distance;
            if(!visited[node]){
                visited[node] = true;
                for(int i = 0; i<children.length; i++) {
                    if ((!visited[i] && children[i] != 0) && distTo[i] > distTo[node] + children[i]) {
                        visited[temp.node] = true;
                        distTo[i] = distTo[node] + children[i];
                        pq.add(new Vertex(i, distTo[i]));

                    }
                }

            }

        }
    }
}
class Vertex implements Comparable{
    int distance;
    int node;
    public Vertex(int n, int d){
        node = n;
        distance = d;
    }

    @Override
    public int compareTo(Object o) {
        return distance - ((Vertex)o).distance;
    }

}

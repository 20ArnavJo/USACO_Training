package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class pwrfail {
    static double[][] adjMatrix;
    static int n;
    static double[] distTo;
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        n = Integer.parseInt(st.nextToken()); //number of verticies
        int w = Integer.parseInt(st.nextToken());
        adjMatrix = new double[n+1][n+1];
        int[][] clowny = new int[n+1][n+1];
        int[][] point = new int[2][n + 1];

        st = new StringTokenizer(input.readLine());
        double m = Double.parseDouble(st.nextToken());
        for(int i = 1; i<=n; i++){
            st = new StringTokenizer(input.readLine());
            int temp = Integer.parseInt(st.nextToken());
            int temp1 = Integer.parseInt(st.nextToken());
            point[0][i] = temp;
            point[1][i] = temp1;


        }
        for(int i = 0; i<w; i++){
            st = new StringTokenizer(input.readLine());
            int temp = Integer.parseInt(st.nextToken());
            int temp1 = Integer.parseInt(st.nextToken());
            clowny[temp][temp1] = -1;
            clowny[temp][temp1] = -1;
        }
        for(int i = 0; i<=n; i++){
            for(int j = 0; j<=n; j++){
                if( i == 0 || j==0){
                    adjMatrix[i][j] = Double.MAX_VALUE;
                    adjMatrix[j][i] = Double.MAX_VALUE;
                }
                else if(clowny[i][j] == -1 || clowny[j][i] == -1){
                    adjMatrix[i][j] = 0;
                    adjMatrix[j][i] = 0;
                }
                else {
                    double d = dist(point[0][i], point[1][i], point[0][j], point[1][j]);
                    if(d <= m) {
                        adjMatrix[i][j] = d;
                        adjMatrix[j][i] = d;
                    }
                    else {
                        adjMatrix[i][j] = Double.MAX_VALUE;
                        adjMatrix[j][i] = Double.MAX_VALUE;
                    }
                }

            }
        }
        distTo = new double[n+1];
        for(int i = 0; i<n + 1; i++){
            distTo[i] = Double.MAX_VALUE;
        }
        djikstra(1);
        if(distTo[n] <= 1000000000){
            System.out.println(((int) (1000*distTo[n])));
        }
        else {
            System.out.println("-1");
        }



    }
    public static double dist(int a, int b, int c, int d){
        return Math.sqrt(((double)Math.pow(((double)a-c), 2)) + ((double)Math.pow(((double)b-d), 2)));
    }
    public static void djikstra(int start){
        Queue<Bertex> pq = new PriorityQueue<Bertex>();
        pq.add(new Bertex(start, 0));
        boolean[] visited = new boolean[n+1];
        distTo[start] = 0;
        while(!pq.isEmpty()){
            Bertex temp = pq.remove();
            double[] children = adjMatrix[temp.node];
            int node = temp.node;
            double distance = temp.distance;
            if(!visited[node]){
                visited[node] = true;
                for(int i = 0; i<children.length; i++) {
                    if ((!visited[i]) && distTo[i] > distTo[node] + children[i]) {
                        visited[temp.node] = true;
                        distTo[i] = distTo[node] + children[i];
                        pq.add(new Bertex(i, distTo[i]));

                    }
                }

            }

        }
    }
}
class Bertex implements Comparable{
    double distance;
    int node;
    public Bertex(int n, double d){
        node = n;
        distance = d;
    }

    @Override
    public int compareTo(Object o) {
        return ((int)(distance - ((Bertex)o).distance));
    }

}


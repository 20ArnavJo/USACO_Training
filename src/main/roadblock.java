package main;
import java.io.*;
import java.util.*;
public class roadblock {

    static int n;
    static int[][] adjMatrixT;
    static int[] parent;
    static ArrayList<Integer> trials = new ArrayList<Integer>();


    public static void main(String[] args) throws IOException{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        n = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());
        int[][] adjMatrix = new int[n+1][n+1];
        parent = new int[n+1];
        for(int i = 0; i<p; i++){
            st = new StringTokenizer(input.readLine());
            int temp = Integer.parseInt(st.nextToken());
            int temp1 = Integer.parseInt(st.nextToken());
            int temp2 = Integer.parseInt(st.nextToken());
            adjMatrix[temp][temp1] = temp2;
            adjMatrix[temp1][temp] = temp2;

        }
        adjMatrixT = new int[n+1][n+1];
        for(int m = 0; m< adjMatrix.length; m++){
            for(int j = 0; j<adjMatrix[0].length; j++){
                int temp9 = adjMatrix[m][j];
                adjMatrixT[m][j] = temp9;
            }
        }
        int first = dijkstra(1)[n];
        int[] temp = parent;
        ArrayList<Integer> path = new ArrayList<Integer>();
        int pointer = n;
        Stack<Integer> back = new Stack<Integer>();
        while(parent[pointer] != 0){
            back.push(pointer);
            pointer = parent[pointer];

        }
        back.push(1);
        while(!back.empty())
        {
            path.add(back.pop());
        }
        for(int i = 0; i<path.size() -  1; i++){



                for(int m = 0; m< adjMatrix.length; m++){
                    for(int j = 0; j<adjMatrix[0].length; j++){
                        int temp9 = adjMatrix[m][j];
                        adjMatrixT[m][j] = temp9;
                    }
                }
                adjMatrixT[path.get(i)][path.get(i + 1)]  = adjMatrixT[path.get(i)][path.get(i + 1)] * 2;
                adjMatrixT[path.get(i + 1)][path.get(i)]  = adjMatrixT[path.get(i + 1)][path.get(i)] * 2;
                trials.add(dijkstra(1)[n]);

        }
        Collections.sort(trials);
        System.out.print(trials.get(trials.size() -1) - first);

    }
    public static int[] dijkstra(int start)
    {
        int[] dist = new int[ n +1];
        boolean[] checked = new boolean[n + 1];
        for(int i = 0; i< n + 1; i++)
        {
            dist[i] = Integer.MAX_VALUE;
        }
        dist[start] = 0;
        for(int i = 1; i< n; i++)
        {
            int node = closest(dist, checked);
            checked[node] = true;
            int[] children = adjMatrixT[node];
            for(int j = 1; j<children.length; j++)
            {
                if((children[j]!=0  && children[j] + dist[node] < dist[j]))
                {
                    dist[j] = children[j] + dist[node];
                    parent[j] = node;
                }
            }
        }
        return dist;
    }

    static public int closest(int[] dist,  boolean[] checked)
    {
        int min = Integer.MAX_VALUE;
        int val = -1;
        for(int i = 1; i<dist.length; i++)
        {
            if(!checked[i] && dist[i]<min)
            {
                val = i;
                min = dist[i];
            }
        }
        return val;
    }

}

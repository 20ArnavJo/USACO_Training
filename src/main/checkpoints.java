package main;

import org.jetbrains.annotations.NotNull;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class checkpoints {
    static int n;
    static int[] nodes;
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        n = Integer.parseInt(st.nextToken());
        nodes = new int[n + 1];
        int a = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(input.readLine());
        nodes[0] = a;
        for(int i = 1; i<n + 1; i++){
            nodes[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(PrimMST());

    }
    public static int PrimMST()
    {
        int[] vals = new int[n + 1];
        int[] past = new int[n + 1];
        boolean[] included = new boolean[n + 1];
        for(int i = 1; i<n + 1; i++)
        {
            vals[i] = Integer.MAX_VALUE;
        }
        past[0] = -1;
        Queue<Node> pq = new PriorityQueue<Node>();
        pq.add(new Node(0, 0));
        while (!pq.isEmpty())
        {
            Node node = pq.remove();
            if(! included[node.node]) {
                included[node.node] = true;
                for (int j = 0; j < nodes.length; j++) {
                    if (vals[j] > Math.abs(nodes[node.node] - nodes[j]) && !included[j]) {

                        vals[j] = Math.abs(nodes[node.node] - nodes[j]);
                        pq.add(new Node(Math.abs(nodes[node.node] - nodes[j]), j));
                        past[j] = node.node;
                    }
                }
            }
        }
        int fin = 0;
        for(int i = 1; i<n; i++)
        {
            int temp = past[i];
            fin+=nodes[temp] - nodes[i];
        }
        return fin;
    }

}
class Node implements Comparable<Node>{
     int dist;
    int node;
    public Node(int dist, int node){
        this.dist = dist;
        this.node = node;
    }

    @Override
    public int compareTo(@NotNull Node o) {
        return dist - o.dist;
    }
}

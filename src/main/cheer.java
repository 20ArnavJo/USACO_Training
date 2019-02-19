package main;
import java.io.*;
import java.util.*;
public class cheer {
    public static void main(String[] args) throws IOException{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        int n = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());
        ArrayList<Edge> edges = new ArrayList<Edge>();
        int[] time = new int[n + 1];
        for(int i = 1; i<n + 1; i++){
            st = new StringTokenizer(input.readLine());
            time[i] = Integer.parseInt(st.nextToken());
        }
        for(int i = 0; i<p; i++){
            st = new StringTokenizer(input.readLine());
            int temp = Integer.parseInt(st.nextToken());
            int temp1 = Integer.parseInt(st.nextToken());
            int temp2 = Integer.parseInt(st.nextToken());
            edges.add(new Edge(temp, temp1, temp2));
        }

    }

}

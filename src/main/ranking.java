package main;
import java.util.*;
import java.io.*;

public class ranking {
    static int n;
    static ArrayList<Integer>[] adjList;
    static ArrayList<Integer>[] adjListT;
    static ArrayList<Integer> dfsVisited = new ArrayList<Integer>();
    static int answer = 0;
    static ArrayList<Integer> dfsVisitedT = new ArrayList<Integer>();

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        n = Integer.parseInt(st.nextToken());
        adjList = new ArrayList[n + 1];
        adjListT = new ArrayList[n + 1];
        for(int i = 0; i<n+1; i++){
            adjList[i] = new ArrayList<Integer>();
        }
        for(int i = 0; i<n+1; i++){
            adjListT[i] = new ArrayList<Integer>();
        }
        int m = Integer.parseInt(st.nextToken());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(input.readLine());
            adjList[Integer.parseInt(st.nextToken())].add(Integer.parseInt(st.nextToken()));
        }
        transpose();
        for (int i = 1; i < n  + 1; i++) {
            DFS(i);
            DFST(i);
            for (int j = 1; j < n + 1; j++) {
                if (!dfsVisited.contains(j) && !dfsVisitedT.contains(j)) {
                    answer++;
                    //adjList[i].add(j);
                    //adjListT[j].add(i);
                }
            }
            dfsVisited.clear();
            dfsVisitedT.clear();
        }
        System.out.print(answer/2);

    }

    static void DFSUtil(int v, boolean visited[]) {
        visited[v] = true;
        dfsVisited.add(v);


        Iterator<Integer> i = adjList[v].listIterator();
        while (i.hasNext()) {
            int n = i.next();
            if (!visited[n])
                DFSUtil(n, visited);
        }
    }

    static void DFS(int v) {

        boolean visited[] = new boolean[n + 1];


        DFSUtil(v, visited);
    }
    static void DFSUtilT(int v, boolean visited[]) {
        visited[v] = true;
        dfsVisitedT.add(v);


        Iterator<Integer> i = adjListT[v].listIterator();
        while (i.hasNext()) {
            int n = i.next();
            if (!visited[n])
                DFSUtilT(n, visited);
        }
    }

    static void DFST(int v) {

        boolean visited[] = new boolean[n + 1];


        DFSUtilT(v, visited);
    }
    static void transpose(){
        for(int i = 1; i<n+1; i++){
            for(int j = 1; j<n+1; j++){
                if(adjList[i].contains(j)){
                    adjListT[j].add(i);
                }
            }
        }
    }
}


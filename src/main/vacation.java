package main;

import kotlin.reflect.jvm.internal.impl.utils.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.Iterator;

public class vacation {
    static ArrayList<Integer>[] adjList;
    static int[] dp;
    static int n;
    static ArrayList<Integer>[] children;
     static ArrayList<Integer>[] grandchildren;

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        n = Integer.parseInt(st.nextToken());
        adjList = new ArrayList[n + 1];
        dp = new int[n + 1];
        children = new ArrayList[n+1];
        grandchildren = new ArrayList[n+1];
        for (int i = 0; i < n + 1; i++) {
            adjList[i] = new ArrayList<Integer>();
            children[i] = new ArrayList<Integer>();
            grandchildren[i] = new ArrayList<Integer>();
        }
        for (int i = 1; i < n; i++) {
            st = new StringTokenizer(input.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adjList[a].add(b);
            adjList[b].add(a);
        }

        DFS(1);
        for(int i = 0; i<n+1; i++){
            for(int j = 0; j<children[i].size(); j++){
                ArrayList<Integer> temp = children[children[i].get(j)];
                for(int k = 0; k<temp.size(); k++) {
                    grandchildren[i].add(temp.get(k));
                }
            }
        }
        dp(1, children, grandchildren);

        int ans = Integer.MIN_VALUE;
        for(int i = 0; i<n+1; i++){
            if(dp[i] > ans){
                ans  = dp[i];
            }
        }
        System.out.println(ans);


    }

    static void DFSUtil(int v,boolean visited[])
    {
        // Mark the current node as visited and print it
        visited[v] = true;

        // Recur for all the vertices adjacent to this vertex
        Iterator<Integer> i = adjList[v].listIterator();
        while (i.hasNext())
        {
            int n = i.next();


            if (!visited[n]) {
                children[v].add(n);
                DFSUtil(n, visited);
            }
        }
    }

    // The function to do DFS traversal. It uses recursive DFSUtil()
    static void DFS(int v)
    {
        // Mark all the vertices as not visited(set as
        // false by default in java)
        boolean visited[] = new boolean[n + 1];

        // Call the recursive helper function to print DFS traversal
        DFSUtil(v, visited);
    }
    static int dp(int curr, ArrayList[] children, ArrayList[] grandchildren){
        if(children[curr].size() == 0){
            dp[curr]  = 1;
            return 1;
        }
        int a = 0;
        int b = 0;
        Iterator<Integer> i = children[curr].listIterator();
        while (i.hasNext()){
            int temp = i.next();
            if(dp[temp] != 0){
                a += dp[temp];
            }

            else {a += dp(temp, children, grandchildren);}
        }
        Iterator<Integer> i2 = grandchildren[curr].listIterator();
        while (i2.hasNext()){
            int temp2 = i2.next();
            if(temp2 != 0){
                b+= dp[temp2];
            }
            else {b += dp(temp2, children, grandchildren);}
        }
        dp[curr] = Math.max(a, b+1);
        return Math.max(a, b+1);
    }
}
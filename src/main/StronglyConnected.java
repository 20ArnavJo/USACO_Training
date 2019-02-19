package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;
import java.util.StringTokenizer;

public class StronglyConnected {


        static int n;
        static ArrayList<Integer>[] adjList;
        static boolean[] visited;
        static int[][] vals;
        static int answer = 0;
        static int counter = 1;
        public static void main(String[] args) throws IOException {
            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(input.readLine());
            n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            adjList = new ArrayList[n+1];
            visited = new boolean[n+1];
            vals = new int[n+1][2];
            for(int i = 0; i<n+1; i++){
                adjList[i] = new ArrayList<Integer>();
            }
            for(int i = 0; i<m; i++){
                st = new StringTokenizer(input.readLine());
                adjList[Integer.parseInt(st.nextToken())].add(Integer.parseInt(st.nextToken()));
            }
            connectedComponents();
            System.out.println(answer);

        }
        static void connectedComponents(){
            for(int i = 1; i<n+1; i++){
                DFS(i);
            }

        }
        static void DFSUtil(int v,boolean visited[], Stack<Integer> s)
        {
            visited[v] = true;
            s.push(v);
            vals[v][0] = counter;
            vals[v][1] = counter;
            counter++;



            Iterator<Integer> i = adjList[v].listIterator();
            while (i.hasNext())
            {
                int n = i.next();
                if (!visited[n]) {
                    DFSUtil(n, visited, s);
                    if(vals[v][1] > vals[n][1]){
                        vals[v][1] = vals[n][1];
                    }

                }
                else if((visited[n] && s.contains(n))){
                    vals[v][1] = Math.min(vals[n][1], vals[v][1]);
                }



            }



            int temp = vals[v][0];
            if(vals[v][0] == vals[v][1]){
                int counter = 0;
                while(vals[s.pop()][0] != temp){
                    counter++;
                }
                if(counter >=1) {answer++;}

            }
        }


        static void DFS(int v)
        {
            //boolean visited[] = new boolean[n + 1];]
            Stack<Integer> s = new Stack<Integer>();
            vals[v][0] = 1;
            vals[v][1] = 1;


            if(!visited[v]){DFSUtil(v, visited, s);}
        }
    }




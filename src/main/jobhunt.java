package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class jobhunt {
    static ArrayList<Edge> edges = new ArrayList<Edge>();
    static double[] distTo;
    static int done;
    static int c;
    public static void main(String[] args)  throws IOException{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        int d = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        int f = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        for(int i = 0; i<p; i++){
            st = new StringTokenizer(input.readLine());
            int  temp = Integer.parseInt(st.nextToken());
            int temp1 =  Integer.parseInt(st.nextToken());
            edges.add(new Edge(temp, temp1, d));
            edges.add(new Edge(temp1, temp, d));
        }
        for(int j = 0; j<f; j++){
            st = new StringTokenizer(input.readLine());
            int  temp = Integer.parseInt(st.nextToken());
            int temp1 =  Integer.parseInt(st.nextToken());
            int temp2 =  Integer.parseInt(st.nextToken());
            edges.add(new Edge(temp, temp1, 0 -d));
            edges.add(new Edge(temp1, temp, temp2 - d));
        }
        distTo = new double[c + 1];
        for(int i = 0; i<+1; i++){
            distTo[i] = Integer.MAX_VALUE;
        }
        distTo[s] = 1;
        bellmanFord(s);
        if(done == 0) {
            Arrays.sort(distTo);
            System.out.println(-1  * distTo[distTo.length - 1]);
        }

    }
    public static void bellmanFord(int start)
    {
      done = 0;
        for(int j = 0 ; j<c; j++){
            for(int i = 0; i<edges.size(); i++){
                if(distTo[edges.get(i).to()] > distTo[edges.get(i).from()] * edges.get(i).weight()){
                    if(j == c - 1){
                        System.out.println("-1");
                        done++;
                        break;
                    }
                    else{
                        distTo[edges.get(i).to()] = distTo[edges.get(i).from()] * edges.get(i).weight();
                    }

                }

            }

        }


    }
}




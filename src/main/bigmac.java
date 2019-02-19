package main;
import java.io.*;
//import java.math.BigDecimal;
import java.util.*;
public class bigmac{
        static double[] distTo;
        static ArrayList<Edge> edges = new ArrayList<Edge>();
        static int n;
        static int done = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        double v = Double.parseDouble(st.nextToken());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        distTo = new double[n+1];
        for(int i = 0; i<m; i++){
            st = new StringTokenizer(input.readLine());
            int temp = Integer.parseInt(st.nextToken());
            int temp1 = Integer.parseInt(st.nextToken());
            double temp2 = Double.parseDouble(st.nextToken());
            edges.add(new Edge(temp, temp1, temp2));
            //edges.add(new Edge(temp1, temp, temp2));

        }
        for(int i = 0; i<n+1; i++){
            distTo[i] = Integer.MAX_VALUE;
        }
        distTo[a] = 1;
        bellmanFord(a);
        if(done == 0){System.out.print((long) (distTo[b] * v));}

    }
    public static void bellmanFord(int start)
    {

        for(int j = 0 ; j<n; j++){
            for(int i = 0; i<edges.size(); i++){
                if(distTo[edges.get(i).to()] > distTo[edges.get(i).from()] * edges.get(i).weight()){
                    if(j == n - 1){
                        System.out.println("0");
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
class Edge implements Comparable
{
    private final int v;
    private final int w;
    private final double weight;
    public Edge(int v, int w, double weight)
    {
        this.v = v;
        this.weight = weight;
        this.w = w;
    }
    public int from()
    {
        return v;
    }
    public int to()
    {
        return w;
    }
    public double weight()
    {
        return weight;
    }
    public int compareTo(Object obj)
    {
        return (int) (100*(weight - ((Edge) obj).weight()));
    }
}
package main;

import org.jetbrains.annotations.NotNull;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class lookup {
    public static void main(String[] args) throws IOException{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        int n = Integer.parseInt(st.nextToken());
        Queue<Point> pq = new PriorityQueue<Point>();
        Point[] things = new Point[n];
        for(int i = 0; i<n; i++){
            st = new StringTokenizer(input.readLine());
            things[i] =new Point(i, Integer.parseInt(st.nextToken()));
        }
        int[] ans = new int[n];
        for(int i = n-1; i>=0; i--){
            pq.add(things[i]);
            ArrayList<Point> trashed = new ArrayList<Point>();
            int min = Integer.MAX_VALUE;
            Point temp = new Point(-1, Integer.MIN_VALUE);
            if(!pq.isEmpty()){
                temp =  pq.remove();
                trashed.add(temp);
            }
            while(temp.value > things[i].value){
                if(temp.index < min){
                    min = temp.index;
                }
                temp = pq.remove();
                trashed.add(temp);
            }
            if(min  == Integer.MAX_VALUE){
                ans[i] = 0;
            }
            else {ans[i] = min;}
            for(int j = 0; j<trashed.size(); j++){
                pq.add(trashed.get(j));

            }


        }
        for(int i = 0; i<n; i++){
            System.out.println(ans[i]);
        }
    }

}
class Point implements Comparable<Point>{
    int value;
    int index;

    public Point(int i, int val){
        value = val;
        index = i;
    }

    @Override
    public int compareTo(Point o) {
        return value - o.value;
    }
}

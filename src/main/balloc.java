package main;
import org.jetbrains.annotations.NotNull;

import java.io.*;
import java.util.*;
public class balloc {
    static int[] capacity;
    public static void main(String[] args)throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        ArrayList<Interval> intervals = new ArrayList<Interval>();
        capacity = new int[n + 1];
        for(int i = 1; i<n + 1; i++){
            st = new StringTokenizer(input.readLine());
            capacity[i] = Integer.parseInt(st.nextToken());
        }
        for(int i = 0; i<m; i++){
            st = new StringTokenizer(input.readLine());
            intervals.add(new Interval(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        Collections.sort(intervals);
        int answer = 0;
        while(!intervals.isEmpty()){
            Interval temp = intervals.remove(0);
            boolean test = true;
            for(int i = temp.start; i<=temp.end; i++){
                if(capacity[i] == 0){
                    test = false;
                }
            }
            if(test == true){
                for(int i = temp.start; i<=temp.end; i++){
                    capacity[i]--;

                }
                answer++;

            }
        }
        System.out.println(answer);

    }
}
class Interval implements Comparable{
    int start;
    int end;
    int difference;
    Interval(int s, int e){
        start = s;
        end = e;
        difference = end - start;
    }
    @Override
    public int compareTo(@NotNull Object o) {
        if(end != ((Interval) o).end) {return end - ((Interval) o).end;}
        return difference - ((Interval) o).difference;
    }
}
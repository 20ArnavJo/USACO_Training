package main;
import java.io.*;
import java.util.*;
public class plank {
    public static void main(String[] args)throws IOException{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        int n = Integer.parseInt(st.nextToken());
        long answer = 0;
        Queue<Long> lengths = new PriorityQueue<Long>();
        for(int i = 0; i<n; i++){
            st = new StringTokenizer(input.readLine());
            lengths.add(Long.parseLong(st.nextToken()));
        }
        while (!lengths.isEmpty()){
            long temp1 = lengths.remove();

            long temp2 = 0;
            if(!lengths.isEmpty()) {
                temp2 = lengths.remove();
                lengths.add(temp1 + temp2);
                answer += temp1;
                answer += temp2;
            }

        }
        System.out.println(answer);
    }
}

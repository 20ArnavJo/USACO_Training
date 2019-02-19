package main;
import java.io.*;
import java.util.*;
public class codes {
    public static void main(String[] args) throws IOException{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        int n = Integer.parseInt(st.nextToken());
        String[] codes = new String[n];
        ArrayList<Interval>[] intervals = new ArrayList[n];
        for(int i = 0; i<intervals.length; i++){
            intervals[i] = new ArrayList<Interval>();
        }
        for(int i = 0; i <n; i++){

            st = new StringTokenizer(input.readLine());
            codes[i] = st.nextToken();
        }
        st = new StringTokenizer(input.readLine());
        String word = st.nextToken();
        for(int i = 0; i<n; i++){
            int curr = 0;
            int start = 0;
            int end = 0;
            int size = codes[i].length();
            for(int j = 0; j<word.length(); j++){
                if(curr == size){
                    intervals[i].add(new Interval(start, end));
                    start = end;
                    curr = 0;
                }
                String temp = codes[i].substring(curr, curr+1);
                if(word.substring(j,j+1).equals(temp)){
                    curr++;
                }
                end++;

            }
        }
        System.out.println("end");

        }
}

package main;
import java.io.*;
import java.util.*;
public class corral {
    static int max;
    static boolean[] used;
    static int answer = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        int c = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] length = new int[2][m];
        used = new boolean[c];
        for(int i = 0; i<m; i++){
            st = new StringTokenizer(input.readLine());
            int start = Integer.parseInt(st.nextToken());
            int curr = Integer.parseInt(st.nextToken());
            length[0][i] = start;
            length[1][i] = curr;
        }
        while(c>0){
  //          int[] temp = findMax(length, used);
           // for(int i = 0; i<temp.length; i++){
           //     used[temp[i]] = true;
           // }
            //c -= max;
            //answer++;

        }
        System.out.println(answer);
    }
    //returns index
    static ArrayList<Integer> findMax(int[][] arr, boolean[] covered){
        max = Integer.MIN_VALUE;
        int index = -1;
        for(int i = 0; i<arr[0].length; i++){
            int coverage = 0;
            for(int j = 0; j<arr[1][i]; j++){
                if(!covered[arr[0][i] + i]){
                    coverage++;
                }
            }

        }
    //    return index;
        return new ArrayList<Integer>();
    }
}

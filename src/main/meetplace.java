package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class meetplace {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] parent = new int[n+1][18];
        ArrayList<Integer[]> queries = new ArrayList<Integer[]>();
        for (int i = 1; i < n; i++) {
            st = new StringTokenizer(input.readLine());
            parent[i+1][0] = Integer.parseInt(st.nextToken());

        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(input.readLine());
            Integer[] temp = {Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())};
            queries.add(temp);

        }
        int[] tempParent = new int[n + 1];
        for(int i = 0; i<n + 1; i++){
            tempParent[i] = parent[i][0];
        }
        int[] level = calcLevel(tempParent, n);
        for(int i = 0; i<queries.size(); i++)
        {
            int jumpA = 0;
            int jumpB = 0;
            int pointerA = queries.get(i)[0];
            int pointerB = queries.get(i)[1];
            int startA = level[queries.get(i)[0]];
            int startB = level[queries.get(i)[1]];
            //System.out.print("StartA = " + startA);
            //System.out.print("StartB = " + startB);
            if(startA  < startB)
            {
                jumpB = startB  - startA;
                int temp6 = jumpB;
                for(int start = 0; start< temp6; start++)
                {
                    pointerB = tempParent[pointerB];
                }
                if(pointerA ==  pointerB)
                {
                    System.out.println(pointerA);
                }
            }
            else
            {
                jumpA = startA  - startB;
                int temp7 = jumpA;
                for(int start = 0; start< temp7; start++)
                {
                    pointerA = tempParent[pointerA];
                }
                if(pointerA ==  pointerB)
                {
                    System.out.println(pointerA);
                }
            }
            //System.out.print(pointerA);
            //System.out.print(pointerB);
            if(pointerA != pointerB)
            {
               while(tempParent[pointerA] != tempParent[pointerB]){
                   pointerA = tempParent[pointerA];
                   pointerB = tempParent[pointerB];
               }
                System.out.println(tempParent[pointerA]);
            }

        }
    }
    public static int[] calcLevel(int[] parent,int n) {
        int[] level = new int[n + 1];
        for(int i = 2; i<n + 1; i++){
            int pointer = i;
            int counter = 0;
            while(pointer != 1){
                pointer = parent[pointer];
                counter++;
            }
            level[i] = counter;
        }
        return level;
    }

}

package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;
import java.util.Set;

public class scales {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int[] weights = new int[n];
        for(int i = 0; i<n; i++){
            st = new StringTokenizer(input.readLine());
            weights[i] = Integer.parseInt(st.nextToken());
        }
        long ans = 0;
        for(int i = 0; i<n; i++){
            ans += weights[i];

        }
        int counter = n-1;
        ArrayList<Long> make = new ArrayList<Long>();
        make.add(ans);
        for(int i = 0; i<=counter; i++){
            int temp = make.size();
            for(int j = 0; j<temp; j++){
                make.add(make.get(j) - weights[i]);
            }
        }
        Collections.sort(make);
        for(int i = make.size() - 1; i>=0; i--){
            if(make.get(i) < c){
                ans = make.get(i);
                break;
            }
        }
        System.out.println(ans);

        }
}

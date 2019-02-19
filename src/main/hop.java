package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class hop {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        int n = Integer.parseInt(st.nextToken());
        int ans = 0;
        for(int i = 0; i<n; i++){
            st = new StringTokenizer(input.readLine());
            int temp = Integer.parseInt(st.nextToken());
            if(temp > 0){
                ans += temp;
            }
        }
        System.out.println(ans);
    }

}

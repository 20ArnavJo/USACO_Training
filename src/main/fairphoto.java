package main;

import org.jetbrains.annotations.NotNull;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class fairphoto {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        ArrayList<Cow> cows = new ArrayList<Cow>();
        for(int i = 0; i<n; i++){
            cows.add(new Cow(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()) ));
        }
        int[][] prefix = new int[8][n];
        Collections.sort(cows);
        for(int i = 0; i<cows.size(); i++){
            if(i > 0)
            {
                for(int j = 0; j<8; j++){
                    prefix[j][i] += prefix[j][i-1];
                }
            }
            prefix[cows.get(i).breed - 1][i]++;
        }

    }
}
class Cow implements Comparable<Cow>
{
    int position;
    int breed;
    Cow(int position, int breed){
        this.position = position;
        this.breed = breed;
    }

    @Override
    public int compareTo(@NotNull Cow o) {
        return position - o.position;
    }
}

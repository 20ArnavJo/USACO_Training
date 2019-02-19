package main;
import java.io.*;
import java.util.*;
public class tsp {
    public static void main(String[] args) throws IOException{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] adjMatrix = new int[n+1][n+1];
        for(int i = 0; i<n+1; i++){
            for(int j = 0; j<n+1; j++){
                adjMatrix[i][j]  = Integer.MAX_VALUE;
            }
        }
        int[][] dp = new int[n+1][n];
        for(int i = 0; i<m; i++){
            st = new StringTokenizer(input.readLine());
            int temp = Integer.parseInt(st.nextToken());
            int temp1 = Integer.parseInt(st.nextToken());
            int temp2 = Integer.parseInt(st.nextToken());
            adjMatrix[temp][temp1] = temp2;
            adjMatrix[temp1][temp] = temp2;
        }
        for(int j = 1; j<n; j++){
            for(int i = 1; i<n + 1; i++){
                int[] temp = new int[n+1];
                for(int l = 0; l<temp.length; l++){
                    temp[l] = Integer.MAX_VALUE;
                }
                for(int z = 1; z<temp.length; z++){
                    if(adjMatrix[z][i] != Integer.MAX_VALUE){temp[z] = dp[z][j-1] + adjMatrix[z][i];}

                }
                int a  = calcMin(temp);
                dp[i][j] = a;

            }

        }
        int[] temp = new int[n+1];
        for(int i = 1; i<n+1; i++){
            temp[i] = dp[i][n-1];

        }
        if(calcMin(temp) != 0) {System.out.println(calcMin(temp));}
        else{
            System.out.println("IMPOSSIBLE");
        }


        }

    static int calcMin(int[] arr)
    {
        int min = Integer.MAX_VALUE;
        int index = -1;
        for(int i = 1; i<arr.length; i++)
        {
            if(arr[i] < min){
                min = arr[i];
                index = i;
            }
        }
        return min;
    }
}

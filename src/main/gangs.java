package main;
import java.util.*;
import java.io.*;
public class gangs {
    public static void main(String[] args) throws IOException {

        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] gang = new int[m];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(input.readLine());
            gang[i] = Integer.parseInt(st.nextToken());
        }
        int[][] totalUsed = new int[m][m];
        int[] total = new int[m];
        int[] temp = new int[m];
        for (int i = 1; i < m; i++) {
            for (int j = i + 1; j < m; j++) {
                while (gang[i] != 0 && gang[j] != 0) {
                    gang[i]--;
                    gang[j]--;
                    totalUsed[i][j]++;
                    total[i]++;
                }
            }
        }
        for (int i = 1; i < m; i++) {
            while (gang[i] != 0) {
                gang[i]--;
                gang[0]--;
                totalUsed[0][i]++;
                total[0]++;
            }

        }
        int win = gang[0];
        if(gang[0] > 0){
            System.out.println("YES");
            System.out.println(win);
            for (int i = 0; i < m; i++) {
                int temp2 = total[i];
                for(int z = 0; z<temp2; z++){
                    System.out.println(i + 1);
                }

                for (int j = i + 1; j < m; j++) {
                    int temp1 = totalUsed[i][j];
                    for(int q = 0; q<temp1; q++){
                        System.out.println(j + 1);
                    }

                }
            }
            for(int i = 0; i<win; i++){
                System.out.println("1");
            }
        }
        else{
            System.out.println("NO");
        }

    }
}

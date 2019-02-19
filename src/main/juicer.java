

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class juicer {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        int n = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int[] oranges = new int[n + 1];
        st = new StringTokenizer(input.readLine());
        for(int i = 1; i<n + 1; i++){

            oranges[i] = Integer.parseInt(st.nextToken());
        }
        int ans = 0;
        int fill = 0;
        for(int i = 1; i<oranges.length; i++){

            if(oranges[i] <= b)
            {
                fill += oranges[i];
            }
            if(fill > d){
                ans++;
                fill = 0;
            }

        }
        System.out.println(ans);
    }
}

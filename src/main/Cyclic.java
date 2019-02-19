
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Cyclic {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        String s = st.nextToken();
        char[] real = s.toCharArray();
        int start = 0;

        for(int i = 0; i<real.length; i++){
            if(real[i] == 'a'){
                start++;

            }
            else {
                break;
            }
        }
        if(start == real.length)
        {
            real[start - 1] = 'z';
        }
        for(int i = start; i<s.length(); i++){
            if(real[i] == 'a'){
                break;
            }
            else {
                real[i]--;
            }
        }
        System.out.println(new String(real));
    }
}

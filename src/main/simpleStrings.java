
import java.io.*;
import java.lang.reflect.Array;
import java.util.*;
public class simpleStrings {
    static HashMap<String, Integer> vals;
    static HashMap<Integer, String> valsA;

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        String word = st.nextToken();
        int[][] dp = new int[2][27];
        String[][] dpA = new String[2][27];

        String[] original = new String[word.length()];
        for (int i = 0; i < word.length(); i++) {
            original[i] = word.substring(i, i + 1);
        }
        vals = new HashMap<String, Integer>();
        valsA = new HashMap<Integer, String>();
        vals.put("a", 1);
        vals.put("b", 2);
        vals.put("c", 3);
        vals.put("d", 4);
        vals.put("e", 5);
        vals.put("f", 6);
        vals.put("g", 7);
        vals.put("h", 8);
        vals.put("i", 9);
        vals.put("j", 10);
        vals.put("k", 11);
        vals.put("l", 12);
        vals.put("m", 13);
        vals.put("n", 14);
        vals.put("o", 15);
        vals.put("p", 16);
        vals.put("q", 17);
        vals.put("r", 18);
        vals.put("s", 19);
        vals.put("t", 20);
        vals.put("u", 21);
        vals.put("v", 22);
        vals.put("w", 23);
        vals.put("x", 24);
        vals.put("y", 25);
        vals.put("z", 26);
        valsA.put(1, "a");
        valsA.put(2, "b");
        valsA.put(3, "c");
        valsA.put(4, "d");
        valsA.put(5, "e");
        valsA.put(6, "f");
        valsA.put(7, "g");
        valsA.put(8, "h");
        valsA.put(9, "i");
        valsA.put(10, "j");
        valsA.put(11, "k");
        valsA.put(12, "l");
        valsA.put(13, "m");
        valsA.put(14, "n");
        valsA.put(15, "o");
        valsA.put(16, "p");
        valsA.put(17, "q");
        valsA.put(18, "r");
        valsA.put(19, "s");
        valsA.put(20, "t");
        valsA.put(21, "u");
        valsA.put(22, "v");
        valsA.put(23, "w");
        valsA.put(24, "x");
        valsA.put(25, "y");
        valsA.put(26, "z");


        String curr = original[0];
        for (int i = 1; i < 27; i++) {
            if (vals.get(curr) != i) {
                dp[0][i] = 1;
            } else {
                dp[0][i] = 0;
            }
            dpA[0][i] = valsA.get(i);
        }
        for (int i = 1; i < word.length(); i++) {
            String temp = original[i];
            for (int j = 1; j <= 26; j++) {
                String[] a = findMin(dp[0], j, temp, dpA);
                dp[1][j] = Integer.parseInt(a[0]);
                dpA[1][j] = a[1] + valsA.get(j);
            }
            for (int k = 0; k < 27; k++) {
                dp[0][k] = dp[1][k];
                dpA[0][k] = dpA[1][k];
            }
            Arrays.fill(dp[1], 0);
            Arrays.fill(dpA[1], null);

        }
        int ans = Integer.MAX_VALUE;
        int index = -1;
        for (int i = 1; i <= 26; i++) {
            if (dp[0][i] < ans) {
                ans = dp[0][i];
                index = i;
            }
        }
        System.out.println(dpA[0][index]);


    }

    static String[] findMin(int[] arr, int j, String curr, String[][] dpA) {
        int min = Integer.MAX_VALUE;
        int index = -1;
        String[] ans = new String[2];

        for (int i = 1; i < arr.length; i++) {
            if (i != j && arr[i] < min) {
                min = arr[i];
                index = i;
            }
        }
        if (vals.get(curr) == j) {
            ans[0] = Integer.toString(min);
            ans[1] = dpA[0][index];
            return ans;

        }
        ans[0] = Integer.toString(min + 1);
        ans[1] = dpA[0][index];
        return ans;

    }
}
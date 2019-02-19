import java.io.*;
import java.util.StringTokenizer;

public class Solver {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("runner.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("output.txt"));
        String ln;
        while ((ln = br.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(ln);
            if (st.hasMoreTokens() && st.nextToken().equals("try")) {
                br.readLine();
                br.readLine();
            } else {
                pw.println(ln);
            }
        }
        pw.close();
    }
}

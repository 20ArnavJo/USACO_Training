package main;
//mostly tested
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class FenwickTree {
    static int[] tree;
    static int[] original;
    public static void main(String[] args) throws IOException{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        int changes = Integer.parseInt(st.nextToken());
        int queries = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken()); //total number of elements
        original = new int[n+1];
        int[][] updates = new int[2][changes];
        int[][] questions = new int[2][queries];
        for(int i = 1; i<n + 1; i++){
            st = new StringTokenizer(input.readLine());
            original[i] = Integer.parseInt(st.nextToken());
        }
        for(int i = 0; i<changes; i++){
            st = new StringTokenizer(input.readLine());
            updates[0][i] = Integer.parseInt(st.nextToken());
            updates[1][i] = Integer.parseInt(st.nextToken());
        }
        for(int i = 0; i<queries; i++){
            st = new StringTokenizer(input.readLine());
            questions[0][i] = Integer.parseInt(st.nextToken());
            questions[1][i] = Integer.parseInt(st.nextToken());
        }

        tree = new int[n + 1];
        build(n);
        for(int i = 0; i<changes; i++){
            update(updates[0][i],updates[1][i], n);
        }
        for(int i = 0; i<queries; i++){
            System.out.println(query(questions[0][i], questions[1][i]));
        }
    }
    //this method builds the fenwick tree with n elements
    static void build(int n){
        for(int i = 1; i<n + 1; i++){
            int temp = i;
            while (temp <= n){
                tree[temp] += original[i];
                temp += temp&-temp;
            }
        }

    }
    //increases element b by x (in a fenwick tree with n elements)
    static void update(int b, int x, int n){

        int change = x;
        int pointer = b;
        while(pointer <= n){
            int LSB = pointer&-pointer;
            tree[pointer] += change;
            pointer += LSB;

        }

    }
    //find sum of elements from [a ... b] (inclusive)
    static int query(int a,int b){
        int first = 0;
        int second = 0;
        a--;
        while (a > 0){
            first += tree[a];
            a -= a&-a;

        }
        while (b>0){
            second += tree[b];
            b -= b&-b;
        }
        return second - first;

    }

}

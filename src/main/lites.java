package main;
import java.io.*;
import java.util.*;
public class lites {
    public static void main(String[] args) throws IOException
    {

        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        ArrayList<Integer[]> queries = new ArrayList<Integer[]>();
        ArrayList<Integer[]> updates = new ArrayList<Integer[]>();
        for(int i = 0; i<m; i++)
        {
            st = new StringTokenizer(input.readLine());
            int temp = Integer.parseInt(st.nextToken());
            int temp1 = Integer.parseInt(st.nextToken());
            int temp2 = Integer.parseInt(st.nextToken());
            if(temp == 0){
                Integer[] temp3 = {temp1, temp2};
                updates.add(temp3);
            }
            if(temp == 1){
                Integer[] temp4 = {temp1, temp2};
                queries.add(temp4);
            }
        }
        int[] segTree = new int[4*n];
        int[] lazy = new int[4*n];
        for(int i = 0; i<updates.size(); i++) {
            Integer[] curr = updates.get(i);
            update(1, 1, n, curr[0], curr[1], segTree, lazy);
        }
        for(int i = 0; i<4*n; i++)
        {
            //System.out.print(segTree[i] + " ");
        }
        for(int i = 0; i<queries.size(); i++)
        {
            Integer[] temp =  queries.get(i);
            int a = temp[0];
            int b = temp[1];
            System.out.println(query(1,1,n,a,b,segTree, lazy));
        }


    }
    // updates [a ... b]
    public static void update(int node, int l, int r, int a, int b, int[] segTree, int[] lazy){
        if(l >= a && r <= b)
        {
            int temp = segTree[node];
            segTree[node] = (r-l + 1) - temp;
            lazy[node]++;

        }
        else if(l!=r)
        {
            down(node, l, r, segTree, lazy);
            int mid = (l + r)/2;


            update(2*node, l, mid, a,b,segTree,lazy);
            update(2*node + 1, mid+1, r, a,b,segTree,lazy);
            segTree[node] = segTree[2*node] + segTree[2*node + 1];
        }



    }
    public static void down(int node, int l, int r, int[] segTree, int[] lazy){
        if(lazy[node] % 2 == 1) {
            lazy[node] = lazy[node] - 1;
            int mid = (l + r) / 2;
            int temp = segTree[2 * node];
            segTree[2 * node] = (mid - l + 1) - temp;
            int temp2 = segTree[2 * node + 1];
            segTree[2 * node + 1] = (r - mid) - temp2;
            lazy[2 * node] = lazy[2 * node] + 1;
            lazy[2 * node + 1] = lazy[2 * node + 1] + 1;
            //segTree[node] = segTree[2*node] + segTree[2*node + 1];
        }

    }
    public static int query(int node, int l, int r, int a, int b,int[] segTree, int[] lazy){

        if(b >=r && a <= l)
        {
           return segTree[node];
        }
        down(node, l, r, segTree, lazy);
        int mid = (l+r)/2;
        if (a<=mid && b>mid){
            return (query(2*node,l,mid,a,b,segTree, lazy) + query(2*node + 1,mid+1,r,a,b,segTree, lazy));
        }
        else if(a<=mid){
            return query(2*node,l,mid,a,b,segTree, lazy);
        }
        else if(b>mid){
            return query(2*node + 1,mid+1,r,a,b,segTree, lazy);
        }
        return 0;
    }
}


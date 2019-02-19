package main;
//needs bug fixes
import java.io.*;
import java.util.*;
public class SegmentTree {
    public static void main(String[] args){

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




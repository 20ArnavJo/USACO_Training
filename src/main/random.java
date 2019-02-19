package main;
import java.io.*;
import java.util.*;

public class random {
    public static void main(String[] args){

    }
    public static ArrayList<Integer> withoutDups(int[] a){
        Set<Integer> temp = new HashSet<Integer>();
        ArrayList<Integer> ans = new ArrayList<Integer>();
        for(int i = 0; i<a.length; i++){
            boolean hi = temp.add(a[i]);
            if(hi){
                ans.add(a[i]);
            }
        }
        return ans;
    }
}

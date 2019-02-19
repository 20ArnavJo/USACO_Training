package main;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class testing {
    public static void main(String[] args){
        int curr = -1;
        int ans = 0;
        for(int i = 1; i<=10000; i++){
            ans += curr*i;
            if(Math.pow(((int)Math.sqrt(i)), 2) == i){
                curr *= -1;
                System.out.println(i);
            }
        }
        System.out.println(ans);
        /*
       ArrayList<Point>[] clown = new ArrayList[2];
       clown[0].add(new Point(0,0));
       for(int i = 0; i<2017; i++){
           for(int j = 0; j<clown[0].size(); j++){
               if(!clown[1].contains(new Point(clown[0].get(j).index - 1, clown[0].get(j).value))){

               }
           }
       }
       */
        ArrayList<Pair> q = new ArrayList<>();
        q.add(new Pair(0,0,0,0));
        for(int i = 0; i<6; i++){
            ArrayList<Pair> temp = new ArrayList<Pair>();
            while (!q.isEmpty()){
                temp.add(q.remove(q.size() - 1));
            }
            for(int j = 0; j<temp.size(); j++){
                int x = temp.get(j).getx();
                int y = temp.get(j).gety();
                int z = temp.get(j).getz();
                int k = temp.get(j).getk();
                q.add(new Pair(x-1,y,z,k));
                q.add(new Pair(x+1,y,z,k));
                q.add(new Pair(x,y - 1,z,k));
                q.add(new Pair(x,y + 1,z,k));
                q.add(new Pair(x,y,z - 1,k));
                q.add(new Pair(x,y,z + 1,k));
                q.add(new Pair(x,y,z,k - 1));
                q.add(new Pair(x,y,z,k + 1));
            }

        }
        int ans3 = 0;
        while (!q.isEmpty()){
            Pair temp = q.remove(q.size() - 1);
            if(new Pair(0,0,0,0).equals(temp))
            {
               ans3++;

            }
            if(temp.getx() == 6){
                System.out.println("6");
            }
        }
        System.out.println(ans3);





    }

}
class Pair{
   private int x;
    private int y;
    private int z;
    private int k;
    public Pair(int x,int y,int z,int k){
        this.x = x;
        this.y = y;
        this.z = z;
        this.k = k;
    }
    int getx(){
        return x;
    }
    int gety(){
        return y;
    }
    int getz(){
        return z;
    }
    int getk(){
        return k;
    }

    @Override
    public boolean equals(Object obj) {
        Pair temp = ((Pair) obj);
        boolean ans = true;
        if(temp.getx() != x){
            ans = false;
        }
        if(temp.gety() != y){
            ans = false;
        }
        if(temp.getz() != z){
            ans = false;
        }
        if(temp.getk() != k){
            ans = false;
        }
        return ans;
    }
}

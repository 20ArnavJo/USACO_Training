package main;
import java.util.*;
public class flip_Coin {
    public static void main(String[] args){
        int a =0;
        int b = 0;
        int c = 0;
        for(int j = 0; j<10; j++) {
            for (int i = 0; i < 1000000000; i++) {
                double temp = Math.random();
                if (temp > 0.5) {
                    a++;
                }
                else if (temp == 0.5) {
                    c++;
                }
                else {
                    b++;
                }
            }
        }

        System.out.println("Heads: " + a);
        System.out.println("Tails: " + b);
        System.out.println("difference: " + Math.abs(b-a));
        System.out.println("Random: " + c);
    }
}

package main;

public class Random2 {
    public static void main(String[] args){
        for(int i = -1000; i<=1000; i++){
            for(int j = -1000; j<1000; j++){
                for(int k = -1000; k<1000; k++){
                    if(i*i*i + 32*j + 2*k == 2018 && j*j*j + i*32 + 2*k == 1115){
                        System.out.println(i*i + j*j + k*k);
                        System.out.println(i);
                        System.out.println(j);
                        System.out.println(k);
                    }
                }
            }
        }


    }

}

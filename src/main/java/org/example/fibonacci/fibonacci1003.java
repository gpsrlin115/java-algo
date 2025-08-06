package org.example.fibonacci;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class fibonacci1003{
    static int zero_c;
    static int one_c;
    static int[][] memo;

    public static int fibo(int n){
        if (n==0){
            zero_c++;
            return 0;
        }
        else if(n==1){
            one_c++;
            return 1;
        } else{
            return fibo(n-1) + fibo(n-2);
        }

    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i<T; i++){
            zero_c = 0;
            one_c = 0;
            int input = Integer.parseInt(br.readLine());
            fibo(input);
            System.out.println(zero_c+" "+one_c);
        }
    }
}
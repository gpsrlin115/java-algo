package org.example.fibonacci;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class fibonacci1003{
    static int[][] memo;

    public static int[] fibo(int n){
        if(memo[n][0] != -1 && memo[n][1] != -1){
            return memo[n];
        }
        if (n==0){
            memo[n][0] = 1;
            memo[n][1] = 0;
        }
        else if(n==1){
            memo[n][0] = 0;
            memo[n][1] = 1;
        } else{
            int[] fibo1 = fibo(n-1);
            int[] fibo2 = fibo(n-2);
            memo[n][0] = fibo1[0] + fibo2[0];
            memo[n][1] = fibo1[1] + fibo2[1];
        }
        return memo[n];
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        memo = new int[41][2];
        for (int i = 0; i < 41; i++) {
            memo[i][0] = -1;
            memo[i][1] = -1;
        }
        for (int i = 0; i<T; i++){
            int input = Integer.parseInt(br.readLine());

            int[] result = fibo(input);
            System.out.println(result[0]+" "+result[1]);
        }
    }
}
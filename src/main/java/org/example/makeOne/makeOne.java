package org.example.makeOne;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class makeOne {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N+1];
        dp[1] = 0; //1은 이미 1이니까.
        for (int i = 2; i<=N; i++){
            dp[i] = dp[i-1] + 1;
            if(i%2==0){ //if x % 2 == 0 -> x/2
                dp[i] = Math.min(dp[i],dp[i/2]+1);
            }
            if(i%3==0){ //if x % 3 == 0 -> x/3
                dp[i] = dp[i/3]+1;
            }
        }
        bw.write(String.valueOf(dp[N]));
        bw.flush();
        bw.close();
        br.close();
    }
}

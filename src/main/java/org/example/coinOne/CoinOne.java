package org.example.coinOne;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CoinOne {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] coin = new int[n];
        for(int i = 0; i<n; i++){
            coin[i] = Integer.parseInt(br.readLine());
        }
        int[] dp = new int[k+1];
        dp[0] =1;
        for (int value : coin) {
            for (int j = value; j <= k; j++) {
                dp[j] += dp[j - value];
            }
        }
        System.out.println(dp[k]);
    }
}

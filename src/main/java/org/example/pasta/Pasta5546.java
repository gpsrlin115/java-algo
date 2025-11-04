package org.example.pasta;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Pasta5546 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] fixed = new int[N+1];

        for(int i =0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int day = Integer.parseInt(st.nextToken());
            int pasta = Integer.parseInt(st.nextToken());
            fixed[day] = pasta;
        }

        int[][][] dp = new int[N+1][4][3]; // 0은 안씀, 3가지, 3일 미만 제한
        if(fixed[1]!=0){
            dp[1][fixed[1]][1] = 1;
        } else{
            for(int j = 1; j<=3; j++) dp[1][j][1] = 1;
        }
        for(int i =2; i<=N;i++){
            for(int j =1; j<=3; j++){
                //정해진 날 스킵
                if(fixed[i]!=0&&fixed[i]!=j) continue;

                for(int prev = 1; prev<=3; prev++){
                    if(prev==j) continue;
                    dp[i][j][1] = (dp[i][j][1]+dp[i-1][prev][1]+dp[i-1][prev][2])%10000;
                }
                dp[i][j][2] = dp[i-1][j][1]%10000;
            }
        }
        int result = 0;
        for(int j=1; j<=3; j++){
            result = (result+dp[N][j][1]+dp[N][j][2])%10000;
        }
        System.out.println(result);
    }
}
//수 합산 전에 %10000으로 해야 할 수 있다.
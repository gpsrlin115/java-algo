package org.example.friend;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ1058 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        boolean[][] f = new boolean[n][n];

        for(int i = 0; i<n; i++){
            String s = br.readLine().trim();
            for(int j = 0; j<n; j++){
                f[i][j] = (s.charAt(j)=='Y');
            }
        }
        int rs = 0;

        for(int i = 0; i<n; i++){
            boolean[] tf = new boolean[n];//two-friend

            for(int j = 0; j<n; j++){
                //직접 칭기
                if(f[i][j]) tf[j] = true;
            }
            for(int k = 0; k<n; k++){
                if(!f[i][k])continue; //i와k가 친구여야함
                for(int j = 0; j<n; j++){
                    if(f[k][j]) tf[j] = true;
                }
            }
            tf[i] = false;

            int cnt = 0;
            for(int j = 0; j<n; j++){
                if(tf[j]) cnt++;
            }
            rs = Math.max(rs, cnt);
        }
        bw.write(String.valueOf(rs));
        bw.flush();
        bw.close();
        br.close();
    }
}

package org.example.RGBStreets;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class RgbStreets1149 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N =  Integer.parseInt(br.readLine());
        int[][] map = new int[N][3];
        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            map[i][0]  = Integer.parseInt(st.nextToken());
            map[i][1] = Integer.parseInt(st.nextToken());
            map[i][2] = Integer.parseInt(st.nextToken());
        }

        int[][]memo = new int[N][3];
        memo[0][0] = map[0][0];
        memo[0][1] = map[0][1];
        memo[0][2] = map[0][2];

        for(int i=1;i<N;i++){
            memo[i][0] = Math.min(memo[i-1][1], memo[i-1][2]) + map[i][0];
            memo[i][1] = Math.min(memo[i-1][0], memo[i-1][2]) + map[i][1];
            memo[i][2] = Math.min(memo[i-1][0], memo[i-1][1]) + map[i][2];
        }
        bw.write(String.valueOf(Math.min(memo[N-1][0], Math.min(memo[N-1][1], memo[N-1][2]))));
        bw.flush();
        bw.close();
        br.close();
    }
}

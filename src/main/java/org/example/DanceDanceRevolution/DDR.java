package org.example.DanceDanceRevolution;

import java.io.*;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class DDR {
    static int[][][] dp;
    static int step(int from, int next) {
        if (from == 0) return 2; // 중앙에서 다른 곳
        if (from == next) return 1; // 같은 위치

        switch (from) {
            case 1: // 위
                return next == 3 ? 4 : 3; // 아래로 가면 4, 나머지는 3
            case 2: // 왼쪽
                return next == 4 ? 4 : 3; // 오른쪽으로 가면 4, 나머지는 3
            case 3: // 아래
                return next == 1 ? 4 : 3; // 위로 가면 4, 나머지는 3
            case 4: // 오른쪽
                return next == 2 ? 4 : 3; // 왼쪽으로 가면 4, 나머지는 3
            default:
                return 3;
        }
    }
    static List<Integer> playStep;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        playStep = new ArrayList<>();
        int num;
        while ((num = Integer.parseInt(st.nextToken())) != 0) {
            playStep.add(num);
        }
        int n = playStep.size();
        if(n==0){
            bw.write("0");
        }
        dp = new int[n][5][5];
        for(int i =0; i<n; i++) for(int j = 0; j<5; j++) Arrays.fill(dp[i][j], -1);
        int first = playStep.get(0);
        dp[0][first][0] = 2; // 왼발
        dp[0][0][first] = 2; // 오른발
    }
}

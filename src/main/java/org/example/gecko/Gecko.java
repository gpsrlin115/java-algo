package org.example.gecko;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Gecko {
    static int h, w;

    public static int solve(int[][] arr, int[][] dp, int y, int x) {
        if (y == 0) return arr[0][x];
        if (dp[y][x] != -1) return dp[y][x];

        int maxPrev = solve(arr, dp, y - 1, x); // 바로 위
        if (x > 0) maxPrev = Math.max(maxPrev, solve(arr, dp, y - 1, x - 1)); // 왼쪽 대각선
        if (x < w - 1) maxPrev = Math.max(maxPrev, solve(arr, dp, y - 1, x + 1)); // 오른쪽 대각선

        dp[y][x] = maxPrev + arr[y][x];
        return dp[y][x];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        h = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());

        int[][] arr = new int[h][w];
        for (int i = 0; i < h; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < w; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] dp = new int[h][w];
        for (int i = 0; i < h; i++)
            for (int j = 0; j < w; j++)
                dp[i][j] = -1;

        int ans = 0;
        for (int i = 0; i < w; i++) {
            ans = Math.max(ans, solve(arr, dp, h - 1, i));
        }
        System.out.println(ans);
    }
}
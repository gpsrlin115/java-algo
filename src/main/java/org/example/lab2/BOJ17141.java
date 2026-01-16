package org.example.lab2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ17141 {
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    static int n,m;
    static int answerTime;
    static int[][] map;
    static boolean[][] visited;
    /*
    0 빈칸
    1 벽
    2 바이러스를 놓을 수 있는 칸
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][n];
        for(int i = 0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }
}

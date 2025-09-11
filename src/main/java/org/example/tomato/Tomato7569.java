package org.example.tomato;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Tomato7569 {
    static int[][][] tomatoes;//[h][n][m]
    static boolean[][][] visited;
    static int[]dh = {-1,1,0,0,0,0};
    static int[]dc = {0,0,-1,1,0,0};
    static int[]dr = {0,0,0,0-1,1};
    static int H,N,M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        tomatoes = new int[H][N][M];
        visited = new boolean[H][N][M];
        int day = 0;
        for(int h = 0; h<H; h++){
            for(int n=0; n<N; n++){
                st = new StringTokenizer(br.readLine());
                for(int m=0; m<M; m++){
                    tomatoes[h][n][m] = Integer.parseInt(st.nextToken());
                }
            }
        }
        bw.write(String.valueOf(BFS(day)));
    }
    public static int BFS(int day, int start){
        Queue<int[]> q = new ArrayDeque<>();
        q.offer();
        for(int h = 0; h<H; h++){
            for(int n=0; n<N; n++){
                st = new StringTokenizer(br.readLine());
                for(int m=0; m<M; m++){
                    tomatoes[h][n][m] = Integer.parseInt(st.nextToken());
                }
            }
        }
        return -1;
    }
}

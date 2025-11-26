package org.example.eatApple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class EatApple {
    static int N,M;
    static int[][] map;
    static int[] directions = {0, 1, 2, 3}; //0 : 오른쪽, 1: 아래, 2: 왼쪽, 3: 위
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};
    static Apple[] apples;
    static class Apple{
        int r,c;

        public Apple(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc<=T; tc++){
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            apples = new Apple[11];
            int appleCnt=0;
            for(int i = 0; i<N; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j<N; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            //초기 좌표와 회전 횟수 최소화 (사과위치 순서대로 이동하면서 회전 횟수 계산)
            int rotationCnt = 0;
            int curR = 0;
            int curC = 0;
            int curD = 1;
            for(int appleNum = 1; appleNum<=appleCnt; appleNum++){
                Apple target = apples[appleNum];
            }
        }
    }
    static int calculateRotate(int sr, int sc, int tr, int tc, Apple target){
        return 0;
    }
}

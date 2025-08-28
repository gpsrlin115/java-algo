package org.example.crushBrick;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//구슬을 N번 떨어뜨려서 최대한 많은 벽돌을 제거하는 문제
//벽돌은 1~9의 숫자가 적혀있고, 숫자만큼 상하좌우로 벽돌을 제거
//벽돌이 제거되면 위에 있는 벽돌이 아래로 떨어짐
//벽돌이 없는 곳에 구슬을 떨어뜨리면 아무 일도 일어나지 않음
//벽돌이 모두 제거되었을 때 0을 출력
//구슬은 좌우로만 이동가능 => W로 훑어서 그 라인의 제일 큰 값을 찾음
//
import java.util.LinkedList;
import java.util.Queue;

public class CrushBrickSWEA5656 {
    static int N, W, H;
    static int [] dw = {-1, 1, 0, 0};
    static int [] dh = {0, 0, -1, 1};
    static int[][] map;
    static int[][] mapCopy;
    static int minBricks;

    static class Position{
        int h;
        int w;
        int value;
        public Position(int h, int w, int value){
            this.h = h;
            this.w = w;
            this.value = value;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            String[] input = br.readLine().split(" ");
            N = Integer.parseInt(input[0]);
            W = Integer.parseInt(input[1]);
            H = Integer.parseInt(input[2]);
            minBricks = Integer.MAX_VALUE;
            map = new int[H][W];
            for (int i = 0; i < H; i++) {
                String[] row = br.readLine().split(" ");
                for (int j = 0; j < W; j++) {
                    map[i][j] = Integer.parseInt(row[j]);
                }
            }
            pwr(0, map);
            System.out.println("#" + t + " " + "result_placeholder");
        }
    }
    public static void pwr(int idx, int[][] currentMap){
        if(idx == N){
            minBricks = Math.min(minBricks, countBricks(currentMap));
            return;
        }
        for(int i = 0; i<W-1; i++){
            for(int j = 0; j<H; j++){
                mapCopy[j] = currentMap[j].clone();
            }
            crash(i, mapCopy);
            applyGravity(mapCopy);
            pwr(idx+1, mapCopy);
        }
    }

    public static void crash(int col, int[][] mapCopy){
        Queue<Position> queue = new LinkedList<>();
        queue.offer(new Position(0, col, mapCopy[0][col]));
        boolean[][] visited = new boolean[H][W];
        while(!queue.isEmpty()){
            Position pos = queue.poll();
            if(visited[pos.h][pos.w]) continue;
            visited[pos.h][pos.w] = true;
            int range = pos.value; //폭발 범위
            mapCopy[pos.h][pos.w] = 0;
            for(int d = 0; d<4; d++){
                for(int r = 1; r<range; r++){
                    int nh = pos.h + dh[d]*r;
                    int nw = pos.w + dw[d]*r;
                    if(nh<0 || nh>=H || nw<0 || nw>=W) continue;
                    if(mapCopy[nh][nw] > 1 && !visited[nh][nw]){
                        queue.offer(new Position(nh, nw, mapCopy[nh][nw]));
                    } else if(mapCopy[nh][nw] == 1){
                        mapCopy[nh][nw] = 0;
                        visited[nh][nw] = true;
                    }
                }
            }
        }
    }

    public static int countBricks(int[][] mapCopy){
        

        return 0;
    }

    public static void applyGravity(int[][] mapCopy){
    }
}

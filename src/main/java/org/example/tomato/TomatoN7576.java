package org.example.tomato;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class TomatoN7576 {
    static int[][] tomatoes;
    static int M;
    static int N;
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    static Queue<int[]> q = new ArrayDeque<>();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        tomatoes = new int[N][M];
        int unripeCount = 0;
        for(int i =0; i<N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j<M; j++){
                tomatoes[i][j]= Integer.parseInt(st.nextToken());
                if(tomatoes[i][j] == 1){
                    //익었다면
                    q.offer(new int[]{i,j});
                } else if (tomatoes[i][j]==0){
                    unripeCount++;
                }
            }
        }
        if (unripeCount == 0){
            System.out.println(0);
            return;
        }
        int days = bfs();
        for(int i = 0; i<N; i++){
            for(int j = 0; j<M; j++){
                if(tomatoes[i][j] == 0){
                    System.out.println(-1);
                    return;
                }
            }
        }
        System.out.println(days-1);
    }

    static int bfs(){
        int maxDay = 0;
        while(!q.isEmpty()){
            int[] current = q.poll();
            int r = current[0];
            int c = current[1];
            
            for(int i = 0; i<4; i++){
                int nc = c+dc[i];
                int nr = r+dr[i];
                if(nc>=0 && nc<M && nr>=0 && nr<N && tomatoes[nr][nc] == 0){
                    tomatoes[nr][nc] = tomatoes[r][c]+1;
                    q.offer(new int[]{nr,nc});
                }
            }
            maxDay = Math.max(maxDay, tomatoes[r][c]);
        }
        return maxDay;
    }
}

package org.example.crushWall;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class crushWall2206 {
    static int[][] graph;
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    static boolean visited[][][]; // 0은 아직 1은 부순상태
    static int N;
    static int M;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] st = br.readLine().split(" ");
        N = Integer.parseInt(st[0]);
        M = Integer.parseInt(st[1]);
        graph = new int[N][M];
        visited = new boolean[N][M][2];
        for(int i = 0; i<N; i++){
            String[] st2 = br.readLine().split("|");
            for (int j = 0; j<M; j++){
                graph[i][j] = Integer.parseInt(st2[j]);
            }
        }
        int count = 0;
        bfs(0,0,count); //(0,0) -> (N-1,M-1)
        if (count == 0){
            bw.write("-1");
        } else {
            bw.write("result = "+count);
        }
        bw.flush();
        br.close();
        bw.close();
    }

    static void bfs(int r, int c, int count)throws IOException{
        Queue<int[]> queue = new LinkedList<>();
        
        queue.offer(new int[] {r,c});
        visited[r][c][0] =true;
        while(!queue.isEmpty()){
            int[] now = queue.poll();
            int x = now[0];
            int y = now[1];
            for(int i = 0; i<4; i++){
                int nr = x+dr[i];
                int nc = y+dc[i];

                if(nr>=0 && nr<N && nc >= 0 && nc<M && !visited[nr][nc][0]){
                    if (graph[nr][nc] == 0){
                        queue.offer(new int[] {nc,nr});
                        visited[nr][nc][0] = true;
                        count++;
                    }
                    else if (graph[nr][nc] == 1){
                            queue.offer(new int[] {nr,nc});
                            visited[nr][nc][1] = true;
                            count++;
                    }
                }
            }
        }
    }
}
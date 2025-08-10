package org.example.usukooriwatari;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class koori5578 {
    static int N, M;
    static int[][] grid;
    static boolean[][] visited;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};

    static int DFS (int x, int y){
        visited[x][y] = true;
        int count = 1;// 현재부터
        for(int i = 0; i<N; i++){
            int nx = x+dx[i];
            int ny = y+dy[i];
            for(int j = 0; j<M; j++){
                if(nx>=0 && nx <N && ny>=0 && ny<M){
                    //얼음이 있고 아직 방문 x
                    if(grid[nx][ny] == 1 && !visited[nx][ny]){
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        M = Integer.parseInt(br.readLine());
        N = Integer.parseInt(br.readLine());

        grid = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int maxArea = 0;

        //모든위치 완전 탐색
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                //얼음이 있고 아직 방문 x
                int currentArea = DFS(i,j);
                maxArea = Math.max(maxArea, currentArea);
            }
        }
        bw.write(maxArea+"\n");
        bw.flush();
        bw.close();
        br.close();
    }
}

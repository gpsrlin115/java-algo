package org.example.twodots;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class twodots {
    //brute force로 하되
    //탐색은 DFS로 하기.
    //빡구현 문제 ㅇㅇ..
    static boolean[][] visited;
    static int[] dr = {-1,1,0,0}; //상 하 좌 우
    static int[] dc = {0,0,-1,1}; //상 하 좌 우
    static String[] grid;
    static boolean dfs(int x, int y,int px, int py, char color, int N, int M) {
        visited[x][y] = true;// 방문부터.

        for (int i = 0; i<4; i++){
            int nx = x + dr[i];
            int ny = y + dc[i];
            if ( 0<=nx && nx<N && 0<=ny && ny<M){ // 같은 색깔 체크
                if (grid[nx].charAt(ny) == color){
                    //바로 직전에 온 곳이 아닐때
                    if (nx != px || ny != py){
                        //이미 방문한곳 사이클 확인
                        if(visited[nx][ny]){
                            return true;
                        }
                        //방문한 곳이 아니면 계속
                        if (dfs(nx, ny, x, y, color, N, M)){
                            return true;
                        };
                    }
                }
            }
        }
        return false;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new  StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        grid = new String[N];
        for(int i=0;i<N;i++){
            grid[i] = br.readLine();
        }
        visited = new boolean[N][M];
        for (int i=0;i<N;i++){
            for (int j=0;j<M;j++){
                if(!visited[i][j]){
                    if (dfs(i,j,i+1,j+1,grid[i].charAt(j), N, M)){
                        bw.write("Yes");
                        bw.flush();
                        bw.close();
                        br.close();
                        return;
                    }
                }
            }
        }
        bw.write("No");
        bw.flush();
        bw.close();
        br.close();
    }
}

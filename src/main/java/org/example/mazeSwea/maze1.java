package org.example.mazeSwea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class maze1 {
    static int n = 100;
    static int[][] maze = new int[n][n];
    static boolean[][] visited = new boolean[n][n];
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int start = 2;
    static int endr,endc;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int t = 1; t<=10; t++){
            int num = Integer.parseInt(br.readLine());

            for(int i = 0; i<n; i++){
                String[] st = br.readLine().split("");
                for(int j = 0; j<st.length; j++){
                    maze[i][j] = Integer.parseInt(st[j]);
                    if(maze[i][j]==3){
                        endr=i;
                        endc=j;
                    }
                }
            }
            int answer = dfs(1,1);
            System.out.println("#"+t+" "+answer);
        }
    }

    static int dfs(int r, int c){
        if(r==endr && c == endc){
            return 1;
        }
        maze[r][c] = 1;
        for(int i =0; i<4; i++){
            int nr = r+dr[i];
            int nc = c+dc[i];

            if(nr < 0 || nr >= 100 || nc < 0 || nc >= 100) continue;
            if(maze[nr][nc] == 1) continue;

            if(dfs(nr, nc)==1) return 1;
        }
        return 0;
    }
}

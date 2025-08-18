package org.example.puyoPuyo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PuyoPuyo11559 {
    static int N = 12, M = 6;
    static char[][] board = new char[N][M];
    static boolean[][] visited;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw =new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i = 0; i < 12; i++){
            String s = br.readLine();
            board[i] =  s.toCharArray();
        }
        int ppayoen = 0;
        while(true){
            boolean pung = false;
            visited = new boolean[N][M];
            for(int i = 0; i < N; i++){
                for(int j = 0; j < M; j++){
                    if(board[i][j]!='.' && !visited[i][j]){
                        List<int[]> group = bfs(i, j);
                        if(group.size() >= 4){
                            pung = true;
                            for(int[] p : group){
                                board[p[0]][p[1]] = '.';
                            }
                        }
                    }
                }
            }
            if (!pung) break;

            LawsOfGravity();
            ppayoen++;
        }
        bw.write(ppayoen+"\n");
        bw.flush();
        bw.close();
        br.close();
    }
    static List<int[]> bfs (int x, int y){
        List<int[]> group = new ArrayList<>();
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        visited[x][y] = true;
        char color = board[x][y];

        while(!q.isEmpty()){
            int[] current = q.poll();
            int cx = current[0];
            int cy = current[1];
            group.add(current);

            for(int d = 0; d<4; d++){
                int nx = cx + dr[d];
                int ny = cy + dc[d];

                if(nx<0 || nx>=N || ny<0 || ny>=M) continue;
                if(visited[nx][ny]) continue;
                if(board[nx][ny] != color) continue;

                visited[nx][ny] = true;
                q.add(new int[]{nx, ny});
            }
        }
        return group;
    }

    static void LawsOfGravity(){
        for (int col = 0; col < M; col++) {
            List<Character> blocks = new ArrayList<>();
            for(int row = N-1; row>=0; row--){
                if(board[row][col] != '.'){
                    blocks.add(board[row][col]);
                    board[row][col] = '.';
                }
            }
            int row = N-1;
            for (char c : blocks) {
                board[row--][col] = c;
            }
        }
    }
}

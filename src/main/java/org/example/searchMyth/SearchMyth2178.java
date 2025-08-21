package org.example.searchMyth;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SearchMyth2178 {
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, 1, -1};
    static int[][] graph;
    static boolean[][] visited;
    static int N,M;
    static public class Point{
        int x;
        int y;
        int result =0;
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        

        graph = new int[N][M];

        for(int i = 0; i<N; i++){
            String input = br.readLine();
            for (int j = 0; j<M; j++){
                graph[i][j]= input.charAt(j) - '0';
            }
        }
        visited = new boolean[N][M];
        Point p = new Point(0,0);
        bw.write(String.valueOf(bfs(p)));
        bw.flush();
        bw.close();
        br.close();
    }
    public static int bfs(Point p){
        Queue<Point> q = new LinkedList<>();
        q.offer(p);
        visited[p.x][p.y]= true;
        
        while(!q.isEmpty()){
            Point currentP = q.poll();
            int cx = currentP.x;
            int cy = currentP.y;

            for(int i = 0; i<4; i++){
                int nx = cx+dr[i];
                int ny = cy+dc[i];

                if(nx<0||nx>=N|| ny <0 || ny>=M) continue;

                if(!visited[nx][ny] && graph[nx][ny] == 1){
                    q.offer(new Point(nx, ny));
                    visited[nx][ny]=true;
                    ++result;
                }
            }
        }
        return result;
    }
}


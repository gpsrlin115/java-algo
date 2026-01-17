package org.example.RedGreenWeak;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class RGweak10026 {
    static int line;
    static char[][] graph;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static boolean[][] visited;
    static class Point{
        int x;
        int y;
        char target;
        Point(int x, int y, char target){
            this.x = x;
            this.y = y;
            this.target = target;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        line = Integer.parseInt(br.readLine());
        graph = new char[line][line];
        for(int i = 0; i<line; i++){
            String st = br.readLine();
            for(int j = 0; j<line; j++){
                graph[i][j] = st.charAt(j);
            }
        }
        visited = new boolean[line][line];
        int normalCount =0;
        int rgCount = 0;
        for(int i = 0; i<line; i++){
            for(int j = 0; j<line; j++){
                if(!visited[i][j]){
                    bfs(i,j);
                    normalCount++;
                }
            }
        }
        visited = new boolean[line][line];

        for(int i = 0; i<line; i++){
            for(int j = 0; j<line; j++){
                if(!visited[i][j]){
                    RGbfs(i,j);
                    rgCount++;
                }
            }
        }

        System.out.println(normalCount + " " + rgCount);
    }

    public static void bfs(int x, int y){
        Queue<Point> q = new ArrayDeque<>();
        char nowTarget = graph[x][y];
        q.offer(new Point(x, y,nowTarget));
        visited[x][y] = true;

        while(!q.isEmpty()){
            Point current = q.poll();

            for(int i = 0; i<4; i++){
                int nr = current.x+dr[i];
                int nc = current.y+dc[i];

                if(nr<0||nr>=line||nc<0||nc>=line) continue;
                if(graph[nr][nc]==current.target && !visited[nr][nc]){
                    visited[nr][nc] = true;
                    q.offer(new Point(nr, nc, graph[nr][nc]));
                }
            }
        }
    }
    public static void RGbfs(int x, int y){
        Queue<Point> q = new ArrayDeque<>();
        char nowTarget = graph[x][y];
        q.offer(new Point(x,y,nowTarget));
        visited[x][y] = true;
        while (!q.isEmpty()){
            Point current = q.poll();

            for(int i = 0; i<4; i++){
                int nr = current.x+dr[i];
                int nc = current.y+dc[i];
                if(nr<0||nr>=line||nc<0||nc>=line) continue;
                if(visited[nr][nc]) continue;
                if(current.target == 'R' || current.target == 'G') {
                    if(graph[nr][nc] == 'R' || graph[nr][nc] == 'G'){
                        visited[nr][nc] = true;
                        q.offer(new Point(nr,nc,graph[nr][nc]));
                    }
                }
                else if(current.target == 'B' && graph[nr][nc] == 'B'){
                    visited[nr][nc] = true;
                    q.offer(new Point(nr,nc,graph[nr][nc]));
                }
            }
        }
    }
}

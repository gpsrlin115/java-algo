package org.example.lab2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ17141 {
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    static int n,m,empty;
    static int answerTime = 0x3f3f3f3f;
    static int[][] map;
    static List<Point> candidateVirus = new ArrayList<>();
    static class Point{
        int r,c;
        Point(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
    static Point[] selected;
    static int minTime = 0xC0C0C0C0;
    /*
    0 빈칸
    1 벽
    2 바이러스를 놓을 수 있는 칸
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][n];
        for(int i = 0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 0){
                    empty++;
                }else if(map[i][j] == 2){
                    candidateVirus.add(new Point(i,j));
                }
            }
        }
        selected = new Point[m];
        empty += (candidateVirus.size() - m);
        dfs(0,0);
        if(answerTime == 0x3f3f3f3f) System.out.println(-1);
        else{
            System.out.println(answerTime);
        }

    }
    static void dfs(int depth, int start){
        if(depth==m){
            int res = bfs(selected);
            if(res != -1)answerTime = Math.min(answerTime, res);
            return;
        }
        for(int i = start; i<candidateVirus.size(); i++){
            selected[depth] = candidateVirus.get(i);
            dfs(depth+1, i+1);
        }
    }
    static int bfs(Point[] selected){
        Queue<Point> q = new ArrayDeque<>();
        int[][] dist = new int[n][n];
        for(int i = 0; i<n; i++){
            Arrays.fill(dist[i], -1);
        }
        for(int i = 0; i<m; i++){
            q.add(selected[i]);
            dist[selected[i].r][selected[i].c] = 0;
        }
        int infectCount = 0;
        int time = 0;
        while(!q.isEmpty()){
            Point cur = q.poll();
            time = Math.max(time, dist[cur.r][cur.c]);
            for (int i = 0; i<4; i++){
                int nr = cur.r + dr[i];
                int nc = cur.c + dc[i];
                if(nr<0||nc<0||nr>=n||nc>=n) continue;
                if(map[nr][nc]==1) continue;
                if(dist[nr][nc]!=-1) continue;
                dist[nr][nc] = dist[cur.r][cur.c] + 1;
                q.add(new Point(nr,nc));
                infectCount++;
            }

        }
        if(infectCount == empty){
            return time;
        }
        return -1;
    }
}

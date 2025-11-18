package org.example.Hunter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Hunter {
    static int N,M;
    static int[][] map;
    static Point[] monsters, clients;
    static int minDist;
    static int totalPoints;
    static int[][] dist; // 거리 저장 (모든 지점 간)
    static Point[] points; // (시작, 몬스터들, 고객들)
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static class Point{
        int r,c;
        Point(int r, int c) {this.r = r; this.c=c;}
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t<=T; t++){
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            monsters = new Point[5];
            clients = new Point[5];
            M = 0;
            for(int i = 0; i<N; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j<N; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if(map[i][j]>0){//양수
                        monsters[map[i][j]] = new Point(i,j);
                        M = Math.max(M, map[i][j]);
                    } else if (map[i][j]<0){//음수
                        clients[-map[i][j]]=new Point(i,j);
                    }
                }
            }
            //총 지점 : 시작(0), 몬스터들(1~M), 고객들(M+1~2M)
            totalPoints = 2*M+1;
            points = new Point[totalPoints];
            points[0] = new Point(0,0); // 헌터 시작 (1,1 -> 0-indexed)
            for(int i = 1; i<=M; i++) points[i] = monsters[i];
            for(int i = 1; i<=M; i++) points[M+i] = clients[i];

            //모든 지점간 거리 계산
            dist = new int[totalPoints][totalPoints];
            for (int i = 0; i <totalPoints; i++){
                bfs(i);
            }

            minDist = Integer.MAX_VALUE;
            boolean[] visited = new boolean[totalPoints];
            dfs(0,0,0, visited); //시작 인덱스 0
            bw.write("#"+t+" "+minDist);
        }
    }
    static void bfs (int idx){
        int[][] d = new int[N][N];
        for(int[] row:d) Arrays.fill(row, -1);
        Queue<Point> q = new ArrayDeque<>();
        Point start = points[idx];
        q.add(start);
        d[start.r][start.c] = 0;
        while(!q.isEmpty()){
            Point cur = q.poll();
            for(int k = 0; k<4; k++){
                int nr = cur.r + dr[k];
                int nc = cur.c + dc[k];
                if(nr<0||nc<0||nr>=N||nc>=N)continue;
                if(d[nr][nc]!=-1)continue;
                d[nr][nc] = d[cur.r][cur.c] +1;
                q.add(new Point(nr,nc));
            }
        }
        //다른 모든 포인트와 거리 저장
        for(int i = 0; i<totalPoints; i++){
            if (i==idx) continue;
            Point p = points[i];
            dist[idx][i] = d[p.r][p.c];
        }
    }

    static void dfs(int cur, int count, int sum, boolean[] visited){
        if (sum>= minDist) return; //가지치기
        if (count == 2 * M){
            minDist = Math.min(minDist, sum);
            return;
        }
        for(int next = 1; next<totalPoints; next++){
            if(visited[next]) continue;
            if(next>M && !visited[next-M]) continue; //고객인데 해당 몬스터 아직 방문 안했으면 스킵

            visited[next] = true;
            dfs(next, count+1, sum+dist[cur][next], visited);
            visited[next] = false;
        }
    }
}

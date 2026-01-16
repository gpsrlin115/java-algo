package org.example.flowerRoad;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class FlowerRoad {
    static int seed = 3;
    static int n,answer;
    static int[][] graph;
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        answer = Integer.MAX_VALUE;
        graph = new int[n][n];
        for(int i = 0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<n; j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        visited = new boolean[n][n];
        dfs(0,0);
        System.out.println(answer);
    }
    public static void dfs(int depth, int cost){
        if (depth == 3){
            answer = Math.min(answer, cost);
            return;
        }
        for(int i = 1; i<n-1; i++){
            for(int j = 1; j<n-1; j++){
                if(visited[i][j])continue;
                boolean flag = true;
                for(int d = 0; d<4; d++){
                    int nr = i + dr[d];
                    int nc = j + dc[d];
                    if(visited[nr][nc]){
                        flag = false;
                        break;
                    }
                }
                if(!flag) continue;
                int sum = graph[i][j];
                visited[i][j] = true;
                for(int d =0; d<4; d++){
                    int nr = i+dr[d];
                    int nc = j+dc[d];
                    sum+=graph[nr][nc];
                    visited[nr][nc]=true;
                }
                dfs(depth+1,cost+sum);
                visited[i][j] = false;
                for(int d = 0; d<4; d++){
                    int nr = i + dr[d];
                    int nc = j + dc[d];
                    visited[nr][nc] = false;
                }
            }
        }
    }
}

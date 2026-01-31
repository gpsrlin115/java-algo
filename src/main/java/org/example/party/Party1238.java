package org.example.party;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Party1238 {
    public static class Node{
        int index;
        int cost;
        Node(int index, int cost){
            this.index = index;
            this.cost = cost;
        }
    }
    static final int INF = (int)1e9;
    static int[][] dist = new int[1001][1001];
    static boolean[] visited = new boolean[1001];
    static int n, m, x;
    static int max = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        int[][] graph = new int[n + 1][n + 1];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            graph[a][b] = t;
        }
        for (int i = 1; i <= n; i++) { // dist 배열 초기화
            for (int j = 1; j <= n; j++) {
                if (i == j)
                    dist[i][j] = 0;
                else if (graph[i][j] != 0)
                    dist[i][j] = graph[i][j];
                else
                    dist[i][j] = INF;
            }
        }
        for (int k = 1; k <= n; k++) { // 플로이드 워셜
            for (int a = 1; a <= n; a++) {
                for (int b = 1; b <= n; b++) {
                    dist[a][b] = Math.min(dist[a][b], dist[a][k] + dist[k][b]);
                }
            }
        }
    }
}

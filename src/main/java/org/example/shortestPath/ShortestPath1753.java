package org.example.shortestPath;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class ShortestPath1753 {
    static List<Integer>[] to;   // 인접 정점
    static List<Integer>[] w;    // 가중치
    static int[] dist;
    static boolean[] visited;
    static int V, E, K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken()); // 정점 개수
        E = Integer.parseInt(st.nextToken()); // 간선 개수
        K = Integer.parseInt(br.readLine());  // 시작 정점

        // 그래프 초기화
        to = new ArrayList[V + 1];
        w = new ArrayList[V + 1];
        for (int i = 1; i <= V; i++) {
            to[i] = new ArrayList<>();
            w[i] = new ArrayList<>();
        }

        // 간선 입력
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            to[u].add(v);
            w[u].add(cost);
        }

        dist = new int[V + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        visited = new boolean[V + 1];

        dijkstra(K);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= V; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                sb.append("INF\n");
            } else {
                sb.append(dist[i]).append("\n");
            }
        }
        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();
        br.close();
    }

    static void dijkstra(int start) {
        dist[start] = 0;

        for (int cnt = 0; cnt < V; cnt++) {
            int minIdx = -1, minD = Integer.MAX_VALUE;

            for (int i = 1; i <= V; i++) { // 방문하지 않은 정점 중 최단 거리 선택
                if (!visited[i] && dist[i] < minD) {
                    minD = dist[i];
                    minIdx = i;
                }
            }
            if (minIdx == -1) {
                break;
            }
            visited[minIdx] = true;

            for (int i = 0; i < to[minIdx].size(); i++) { // 인접 정점 완화
                int v = to[minIdx].get(i);
                int cost = w[minIdx].get(i);

                if (!visited[v] && dist[minIdx] + cost < dist[v]) {
                    dist[v] = dist[minIdx] + cost;
                }
            }
        }
    }
}


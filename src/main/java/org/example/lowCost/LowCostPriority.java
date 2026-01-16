//package org.example.lowCost;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//import java.util.StringTokenizer;
//
//public class LowCostPriority {
//    static class Edge {
//        int to, w;
//        Edge(int to, int w) {
//            this.to = to;
//            this.w = w;
//        }
//    }
//
//    static class Node implements Comparable<Node> {
//        int v;
//        int dist;
//        Node(int v, int dist) {
//            this.v = v; this.dist = dist;
//        }
//        @Override public int compareTo(Node o) {
//            return Integer.compare(this.dist, o.dist);
//        }
//    }
//
//    static final int INF = 0x3f3f3f3f;
//    static int N, M;
//    static List<Edge>[] g;
//    static int[] dist;
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        N = Integer.parseInt(br.readLine().trim());
//        M = Integer.parseInt(br.readLine().trim());
//
//        g = new ArrayList[N + 1];
//        for (int i = 1; i <= N; i++) g[i] = new ArrayList<>();
//
//        for (int i = 0; i < M; i++) {
//            StringTokenizer st = new StringTokenizer(br.readLine());
//            int from = Integer.parseInt(st.nextToken());
//            int to = Integer.parseInt(st.nextToken());
//            int cost = Integer.parseInt(st.nextToken());
//            g[from].add(new Edge(to, cost)); // 중복 간선 있어도 그대로 넣어도 OK
//        }
//
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        int start = Integer.parseInt(st.nextToken());
//        int end = Integer.parseInt(st.nextToken());
//
//        dist = new int[N + 1];
//        Arrays.fill(dist, INF);
//    }
//    static int dijkstra(int start, int end){
//
//        return ;
//    }
//}

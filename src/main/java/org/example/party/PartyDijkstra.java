package org.example.party;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class PartyDijkstra {
    public static class Node implements Comparable<Node>{
        int index;
        int cost;
        Node(int index, int cost){
            this.index = index;
            this.cost = cost;
        }
        @Override
        public int compareTo(Node o){
            return this.cost - o.cost;
        }
    }
    static final int INF = (int)1e9;
    static int[][] dist = new int[1001][1001];
    static boolean[] visited = new boolean[1001];
    static int n, m, x;
    static int max = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        List<List<Node>> graph = new ArrayList<>();
        for(int i = 0; i<= n; i++){
            graph.add(new ArrayList<>());
        }
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());//시작
            int b = Integer.parseInt(st.nextToken());//끝
            int t = Integer.parseInt(st.nextToken());//코스트 타임
            graph.get(a).add(new Node(b,t));
        }

        int[] go = dijkstra(graph);

        List<List<Node>> reverse = new ArrayList<>();

        for(int i = 0; i<= n; i++){
            reverse.add(new ArrayList<>());
        }
        for(int i =1; i<=n; i++){
            for(Node node : graph.get(i)){
                reverse.get(node.index).add(new Node(i, node.cost));
            }
        }
        int[] back = dijkstra(reverse);
        for(int i=1; i<=n; i++){
            if(i==x) continue;
            max = Math.max(max, go[i] + back[i]);
        }
        System.out.println(max);
        br.close();
    }

    private static int[] dijkstra(List<List<Node>> graph) {
        int start = x;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int[] dist = new int[n+1];
        Arrays.fill(dist, 0x3f3f3f3f);
        boolean[] visited = new boolean[n+1];

        dist[start] = 0;
        pq.offer(new Node(start, 0));
        while (!pq.isEmpty()){
            Node cur = pq.poll();
            int curNode = cur.index;

            if ( visited[curNode]) continue;
            visited[curNode] = true;

            for (Node naver : graph.get(curNode)){
                if(dist[naver.index]>dist[curNode]+naver.cost){
                    dist[naver.index]=dist[curNode]+naver.cost;
                    pq.offer(new Node(naver.index, dist[naver.index]));
                }
            }
        }
        return dist;
    }

}

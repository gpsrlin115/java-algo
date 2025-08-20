package org.example.lowCost;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class LowCost1916 {
    static int[][] graph;
    static int N;
    static int M;
    static int result;
    static int[] dist;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());//도시의 개수
        M = Integer.parseInt(br.readLine());//버스의 개수
        dist = new int[N+1];
        graph = new int[N+1][N+1];
        for (int i = 1; i<=N; i++){
            Arrays.fill(graph[i], Integer.MAX_VALUE);
            graph[i][i] = 0;
        }
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        StringTokenizer st;
        boolean[] v = new boolean[N+1];
        
        //셋째 줄부터 M+2줄까지 다음과 같은 버스의 정보가 주어진다.
        //먼저 처음에는 그 버스의 출발 도시의 번호가 주어진다. 
        //그리고 그 다음에는 도착지의 도시 번호가 주어지고 또 그 버스 비용이 주어진다. 
        //버스 비용은 0보다 크거나 같고, 100,000보다 작은 정수이다.
        //그리고 M+3째 줄에는 우리가 구하고자 하는 구간 출발점의 도시번호와 도착점의 도시번호가 주어진다.
        // 출발점에서 도착점을 갈 수 있는 경우만 입력으로 주어진다.
        
        for (int i = 0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()); //시작노드
            int c = Integer.parseInt(st.nextToken()); //목적지
            int cost = Integer.parseInt(st.nextToken());//가중치
            
            graph[r][c] = Math.min(graph[r][c], cost);
        }
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        
        dijkstra(v,start);
        bw.write(String.valueOf(dist[end]));
        bw.flush();
        bw.close();
        br.close();
    }
    public static void dijkstra(boolean[] v, int start){
        dist[start] = 0;
        for(int cnt = 0; cnt<N; cnt++){
            int minIdx = -1;
            int minD = Integer.MAX_VALUE;
            for(int i = 1; i <= N; i++){
                if(!v[i] && dist[i]<minD){
                    minIdx = i;
                    minD = dist[i];
                }
            }
            if (minIdx == -1 ) break;
            v[minIdx] = true; //방문처리
            for(int i = 1; i<=N; i++){
                if(graph[minIdx][i] != Integer.MAX_VALUE && !v[i] && graph[minIdx][i]+dist[minIdx]<dist[i]){
                    dist[i] = graph[minIdx][i]+dist[minIdx];
                }
            }
            
        }
    }
}
package org.example.algotemplate;

import java.util.Arrays;

public class Prim {
    static int N = 7;
    public static void main(String[] args) {
        int[][] adj = new int[7][7];

        adj[0][1] = 2;
        adj[1][0] = 2;

        adj[0][2] = 4;
        adj[2][0] = 4;

        adj[0][5] = 8;
        adj[5][0] = 8;

        adj[1][2] = 1;
        adj[2][1] = 1;

        adj[1][3] = 19;
        adj[3][1] = 19;

        adj[2][5] = 5;
        adj[5][2] = 5;

        adj[3][5] = 11;
        adj[5][3] = 11;

        adj[3][4] = 7;
        adj[4][3] = 7;

        adj[3][6] = 15;
        adj[6][3] = 15;

        adj[4][6] = 3;
        adj[6][4] = 3;

        adj[5][4] = 9;
        adj[4][5] = 9;

        int[] dist = new int[N];
        Arrays.fill(dist, Integer.MAX_VALUE);
        boolean[] visited = new boolean[N];

        dist[0] = 0;
        for(int i=0; i<N-1; i++){
            int minIdx = -1;
            int minDist = Integer.MAX_VALUE;
            for(int j=0; j<N; j++){ //dist.length
                if(!visited[j] && dist[j] < minDist) { //방문하지 않은곳중에서 최소거리정점 찾기
                    minIdx = j;
                    minDist = dist[j];
                }
            }
            visited[minIdx] = true;
            for(int k=0; k<visited.length; k++){
                if(!visited[k] && adj[minIdx][k] != 0 && adj[minIdx][k] < dist[k]){
                    dist[k] = adj[minIdx][k];
                }
            }
        }
        System.out.println(Arrays.toString(dist));
    }
}

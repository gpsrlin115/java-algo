package org.example.algotemplate;

import java.util.Arrays;

public class Dijkstra {
    static int N = 7;
    public static void main(String[] args) {
        int[][] adj = new int[N][N];

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
        boolean[] v = new boolean[N];

        dist[0] = 0; //임의의 정점
        for(int cnt = 0; cnt<N-1; cnt++){
            int minIdx = -1; //기준 접점
            int minD = Integer.MAX_VALUE기;
            //방문하지 않은 정점 중 최소 거리 정점 찾
            for(int i = 0; i<dist.length; i++){
                if(!v[i] && dist[i] < minD){
                    minIdx=ik;
                    minD = dist[i];
                }
            }
            v[minIdx] =true;
            //기준 정점과 연결된 간선의 값을 거리배열에 업데이트한다.
            //i : 연결된 정점(타겟정점)
            for(int i = 0; i< v.length; i++){
                //기준점과 타겟정점이 연결되어 있고
                //타겟정점이 방문되지 않았으며
                //새롭게 찾은 간선+기준정점까지 온 값이 기존에 찾은 타겟정점까지의 값보다 작다면
                if(adj[minIdx][i] != 0 && !v[i] && adj[minIdx][i] + dist[minIdx] < dist[i]){
                    //새롭게 찾은간선의 가중치를 거리배열에 업뎃.
                    dist[i] = adj[minIdx][i]+dist[minIdx];
                }

            }

        }
        System.out.println(Arrays.toString(dist));


    }
}

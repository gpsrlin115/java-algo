package org.example.algotemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DijkstraList {
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

        List<Integer> dist = new ArrayList<>(N); // 가중치
        Collections.fill(dist, Integer.MAX_VALUE);
        boolean[] visited = new boolean[N];

        dist.add(0, 0);
        for(int cnt = 0; cnt<N-1; cnt++){
            int standardNode = -1;
            int minDistance = Integer.MAX_VALUE;
            //방문하지 않은 정점 중 최소 거리 정점 찾기
            for (int i = 0; i<dist.size(); i++){
                if(!visited[i] && dist.get(i) < minDistance){
                    standardNode = i;
                    minDistance = dist.get(i);
                }
            }
            visited[standardNode] = true;
            //기준 정점과 연결된 간선의 값을 거리 배열에 업데이트
            //i : 연결된 정점 (타겟 정점, 리스트안의 값)
            for(int i = 0; i<visited.length; i++){
                //기준점과 타겟정점이 연결되어 있고
                //타겟정점이 방문되지 않았으며
                //새롭게 찾은 간선에 기준 정점까지 온 값이
                //기존에 찾은 타겟 정점까지의 값보다 작으면
                if(adj[standardNode][i]!=-0 && !visited[i] && adj[standardNode][i]+dist.get(standardNode)< minDistance){
                    dist.add(i, adj[standardNode][i]+dist.get(standardNode));
                }
            }
        }
        for(Integer i : dist){
            System.out.println(i);
        }
    }
}

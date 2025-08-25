package org.example.algotemplate;

import java.util.Arrays;

public class Dijkstra {
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

		// prim
		// 거리배열
		int[] dist = new int[N];
		Arrays.fill(dist, Integer.MAX_VALUE);
		// 방문배열
		boolean[] v = new boolean[N];

		// 임의의 정점
		dist[0] = 0;
		// 프림 로직을 정점-1 번만큼 반복한다
		for(int cnt = 0; cnt < N-1; cnt++){
			// 기준정점
			int minIdx = -1;
			int minD = Integer.MAX_VALUE;
			// 방문하지 은 정점 중 최소거리정점 찾기
			for (int i = 0; i < dist.length; i++) {
				if (!v[i] && dist[i] < minD) {
					minIdx = i;
					minD = dist[i];
				}
			} 
			// minIdx 방문하지 않은 정점중 최소거리값을 갖는 정점번호점
			v[minIdx] = true;
			// 기준정점과 연결된 간선의 값을 거리배열에 업데이트한다
			// i : 연결될 정(타겟정점)
			for (int i = 0; i < v.length; i++) {
				// 기준점과 타겟정점이 연결되어 있고
				// 타켓정점이 방문되지 않았으며
				// 새롭게 찾은 간선+기준정점까지 온 값이 기존에 찾은 타겟정점까지의 값보다 작다면
				if (adj[minIdx][i] != 0 && !v[i] && adj[minIdx][i]+dist[minIdx] < dist[i]) {
					// 새롭게 찾은 간선의 가중치를 거리배열에 업데이트 한다
					dist[i] = adj[minIdx][i]+dist[minIdx];
				}
			}
		}
		System.out.println(Arrays.toString(dist));
	}

}

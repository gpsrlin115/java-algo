package org.example.algotemplate;

public class Prim {
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


    }
}

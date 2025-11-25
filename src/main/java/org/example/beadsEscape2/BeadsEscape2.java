package org.example.beadsEscape2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BeadsEscape2 {
    static String[][] board;
    static boolean[][] visit;
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    static class Beads{
        int rr; //현재 위치
        int rc;
        int br;
        int bc;
        Beads(int rr, int rc, int br, int bc) {
            this.rr = rr;
            this.rc = rc;
            this.br = br;
            this.bc = bc;
        }
    }
    static class Hole{
        int r; //현재 위치
        int c;
        Hole(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    static Beads beads;

    static int N,M,count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new  StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new String[N][M];
        count =0;
        int rr=0, rc=0, blr=0, blc=0;

        for(int i = 0; i<N; i++){
            board[i]= br.readLine().split("");
            for(int j =0; j<M; j++){
                if (board[i][j].equals("R")){
                    rr =i;
                    rc =j;
                } else if (board[i][j].equals("B")){
                    blr=i;
                    blc=j;
                } else if(board[i][j].equals("O")){
                    hole = new Hole(i,j);
                }
            }
        }
        bfs(beads.rr, beads.rc, beads.br,beads.bc);
    }

    static void bfs(int rr, int rc, int br, int bc ){
        count++;
        visit[rr][rc] = true;
        Queue<Beads> beadsQueue = new ArrayDeque<>();
        beadsQueue.offer(new Beads(sr,sc));
        while(!beadsQueue.isEmpty()){
            Beads b = beadsQueue.poll();
            if (count>10) break;
            for(int i =0; i<4; i++){

            }
        }
    }

}

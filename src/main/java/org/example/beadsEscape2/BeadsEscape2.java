package org.example.beadsEscape2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BeadsEscape2 {
    static String[][] board;
    static boolean[][][][] visit;
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    static class Beads{
        int rr; //현재 위치
        int rc;
        int br;
        int bc;
        int cnt;
        Beads(int rr, int rc, int br, int bc,int cnt) {
            this.rr = rr;
            this.rc = rc;
            this.br = br;
            this.bc = bc;
            this.cnt = cnt;
        }
    }
    static class MoveResult{
        int r; //현재 위치
        int c;
        int dist;
        MoveResult(int r, int c,int dist) {
            this.r = r;
            this.c = c;
            this.dist = dist;
        }
    }
    static Beads beads;
    static int N,M,hr,hc;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new  StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new String[N][M];
        visit = new boolean[N][M][N][M];
        beads = new Beads(0,0,0,0,0);
        for(int i = 0; i<N; i++){
            board[i]= br.readLine().split("");
            for(int j =0; j<M; j++){
                if (board[i][j].equals("R")){
                    beads.rr =i;
                    beads.rc =j;
                } else if (board[i][j].equals("B")){
                    beads.br=i;
                    beads.bc=j;
                } else if(board[i][j].equals("O")){
                    hr = i;
                    hc = j;
                }
            }
        }
        bfs(beads.rr, beads.rc, beads.br,beads.bc);
    }

    static void bfs(int rr, int rc, int br, int bc ){

        Queue<Beads> beadsQueue = new ArrayDeque<>();
        beadsQueue.offer(new Beads(rr,rc,br,bc,1));
        visit[rr][rc][br][bc]= true;
        while(!beadsQueue.isEmpty()){
            Beads b = beadsQueue.poll();
            if(b.cnt>10){
                System.out.println(-1);
                return;
            }
            for(int i =0; i<4; i++){
                MoveResult redMove = move(b.rr, b.rc, i);
                MoveResult blueMove = move(b.br, b.bc, i);

                int nRr = redMove.r;
                int nRc = redMove.c;
                int nBr = blueMove.r;
                int nBc = blueMove.c;

                if(board[nBr][nBc].equals("O")) continue;
                if(board[nRr][nRc].equals("O")) {
                    System.out.println(b.cnt);
                    return;
                }
                if (nRr==nBr && nRc==nBc){
                    if(redMove.dist> blueMove.dist){
                        nRr -= dr[i];
                        nRc -= dc[i];
                    } else{
                        nBr -= dr[i];
                        nBc -= dc[i];
                    }
                }
                if(!visit[nRr][nRc][nBr][nBc]){
                    visit[nRr][nRc][nBr][nBc] = true;
                    beadsQueue.offer(new Beads(nRr,nRc,nBr,nBc, b.cnt+1));
                }
            }
        }
        System.out.println(-1);
    }
    static MoveResult move(int r, int c, int dir){
        int cnt = 0;
        while(!board[r+dr[dir]][c+dc[dir]].equals("#")&&!board[r][c].equals("O")){
            r+=dr[dir];
            c+=dc[dir];
            cnt++;
        }
        return new MoveResult(r,c,cnt);
    }
}

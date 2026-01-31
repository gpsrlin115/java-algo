package org.example.beadEscape;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class beadESC2 {
    static String[][] board;
    static boolean[][][][] visited;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static int N,M,hr,hc;
    static Beads bead;
    static class Beads {
        int rr;
        int rc;
        int blr;
        int blc;
        int cnt;
        Beads(int rr, int rc, int blr, int blc, int cnt){
            this.rr = rr;
            this.rc = rc;
            this.blr=blr;
            this.blc=blc;
            this.cnt=cnt;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new String[N][M];
        visited = new boolean[N][M][N][M];
        int redR=0;
        int redC=0;
        int blueR=0;
        int blueC=0;
        for(int i =0; i<N; i++){
            board[i] = br.readLine().split("");
            for(int j=0; j<M; j++){
                if(board[i][j].equals("R")){
                    redR=i;
                    redC=j;
                } else if(board[i][j].equals("B")){
                    blueR=i;
                    blueC=j;
                } else if (board[i][j].equals("O")) {
                    hr = i;
                    hc = j;
                }
            }
        }
        bead = new Beads(redR, redC, blueR, blueC,0);
        bfs();
    }

    static void bfs(){
        Queue<Beads> q = new ArrayDeque<>();
        q.offer(new Beads(bead.rr, bead.rc, bead.blr, bead.blc,1));
        visited[bead.rr][bead.rc][bead.blr][bead.blc] = true;
        while(!q.isEmpty()){
            Beads bead = q.poll();
            int cRr = bead.rr;
            int cRc = bead.rc;
            int cBr = bead.blr;
            int cBc = bead.blc;
            int count = bead.cnt;

            if(count>10){
                System.out.println(-1);
                return;
            }
            for(int i=0; i<4; i++){
                int nRr = cRr; //일단 이렇게 초기화
                int nRc = cRc;
                int nBr = cBr;
                int nBc = cBc;
                int redDist =0;
                int blueDist =0;
                boolean isRedHole= false;
                boolean isBlueHole= false;

                while(!board[nRr+dr[i]][nRc+dc[i]].equals("#")){
                    nRr += dr[i];
                    nRc += dc[i];
                    redDist++;
                    if(nRr == hr && nRc==hc){
                        isRedHole = true;
                        break;
                    }
                }
                while(!board[nBr+dr[i]][nBc+dc[i]].equals("#")){
                    nBr += dr[i];
                    nBc += dc[i];
                    blueDist++;
                    if(nBr == hr && nBc==hc){
                        isBlueHole = true;
                        break;
                    }
                }
                if (isBlueHole){
                    continue;
                }
                if(isRedHole&&!isBlueHole){
                    System.out.println(count);
                    return;
                }
                if(nRr == nBr && nRc == nBc){
                    if(redDist>blueDist){
                        nRr-=dr[i];
                        nRc-=dc[i];
                    } else{
                        nBr -= dr[i];
                        nBc -= dc[i];
                    }
                }
                if(!visited[nRr][nRc][nBr][nBc]){
                    visited[nRr][nRc][nBr][nBc] = true;
                    q.offer(new Beads(nRr,nRc,nBr,nBc,count+1));
                }
            }
        }
    }
}

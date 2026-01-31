package org.example.eatApple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class EatApple {
    static int N,M,ans;
    static int[][] map;
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc<=T; tc++){
            N = Integer.parseInt(br.readLine());
            ans= 0x3f3f3f3f;
            M =0;
            map = new int[N][N];
            for(int i = 0; i<N; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j<N; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                    M = Math.max(M,map[i][j]);
                }
            }
            calculateRotate(0,0,0,0,1);
            System.out.printf("#%d %d\n", tc,ans);
        }
    }
    static void calculateRotate(int r, int c, int d, int cnt, int target){
        if (target - 1 == M) {
            ans = Math.min(ans, cnt); // 제일 작은 답
            return;
        }
        //현재 자리에 사과가 있다면 먹는다
        if(map[r][c] == target){
            target+=1;
        }

        //회전하는 경우 ( 회전에서 사과가 있다면 or 지도 밖으로 나가면)
        int nr = r+dr[d];
        int nc = c+dc[d];

        if(check(r,c,d,target) || (nr<0||nr>=N||nc<0||nc>=N)){
            int nd = (d+1)%4; // 모듈러 연산 4방
            calculateRotate(r,c,nd,cnt+1,target);
            return;
        }
        calculateRotate(nr,nc,d,cnt,target); //직진하는 경우
    }

    static boolean check(int r, int c, int d, int target){
        int nd = (d+1)%4;
        while(r>=0&&r<N&&c>=0&&c<N){
            r+=dr[nd];
            c+=dc[nd];
            if(r>=0&&r<N&&c>=0&&c<N){
                if(map[r][c]==target) return true; //사과를 발견하면 true!
            }
        }
        return false;
    }
}
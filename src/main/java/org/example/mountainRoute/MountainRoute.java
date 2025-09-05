package org.example.mountainRoute;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class MountainRoute {
    static int N,K; //N : 맵의 사이즈 , K : 최대 공사 가능 깊이
    static int[][] mountain; // (N*N)맵의 정보를 저장한 배열
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static boolean[][] visited;
    static int heighest;
    static int ans;

    public static class info {
        int h, w; //맵 상의 위치
        int height; // (h,w) 지점의 높이
        boolean usedK; // 공사를 진행한 적이 있다면 (true) 아니면(false)
        int len; // 현재까지의 등산로 길이
        info(int h, int w, int height, boolean usedK, int len){
            this.h = h;
            this.w = w;
            this.height = height;
            this.usedK = usedK;
            this.len = len;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc<=T; tc++){
            ans = 0;
            heighest = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            mountain = new int[N][N];
            visited = new boolean[N][N];
            for(int i = 0; i<N; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j <N; j++){
                    mountain[i][j] = Integer.parseInt(st.nextToken());
                    heighest = heighest > mountain[i][j] ? heighest : mountain[i][j];
                }
            }
            for(int i = 0; i<N; i++){
                for(int j = 0; j<N; j++){
                    if(heighest == mountain[i][j]){
                        visited[i][j] = true;
                        info cur = new info(i, j, mountain[i][j], false, 1);
                        sol(cur);
                        visited[i][j] = false;
                    }
                }   
            }
            bw.write("#"+tc+" "+String.valueOf(ans));
            bw.flush();
        }
        bw.close();
        br.close();
    }
    public static void sol(info cur){
        ans = ans > cur.len ? ans : cur.len; //길이가 더 길어 졌을때 만 정답으로 저장

        for(int d = 0; d<4; d++){
            int nh = cur.h + dr[d];
            int nw = cur.w + dc[d];

            if(nh>=0 && nh<N && nw >=0 && nw <N && !visited[nh][nw]){
                int nextHeight = mountain[nh][nw];
                if(nextHeight<cur.height){ // 방문 예정인 위치의 높이가 현재의 높이보다 작은 경우
                    //방문 표시
                    visited[nh][nw] = true;
                    sol(new info(nh, nw, nextHeight, cur.usedK, cur.len+1));
                    visited[nh][nw] = false;
                } else {
                    //현재까지 공사 안하고, 다음 높이에 대해 K 만큼 공사 했을때
                    //현재보다 작을경우에만 가능하게
                    if(!cur.usedK && nextHeight - K < cur.height){
                        visited[nh][nw] = true;
                        int dugHeight = cur.height -1;
                        //최대한 긴 등산로. K만큼의 높이를 다 깎을 필요 없이
                        // 현재 높이보다 1만 작게 깎기
                        sol(new info(nh, nw, dugHeight, true, cur.len+1));
                        visited[nh][nw] = false;
                    }
                }
            }
        }
        return;
    }
}

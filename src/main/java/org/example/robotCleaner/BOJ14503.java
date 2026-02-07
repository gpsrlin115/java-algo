package org.example.robotCleaner;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ14503 {
    static int[] dr = {-1, 0, 1, 0}; // 0: 북 , 1: 동, 2: 남, 3: 서
    static int[] dc = {0, 1, 0, -1};
    static int n, m, ans;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        ans = 0;
        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        simule(r, c, d);
        bw.write(String.valueOf(ans));
        bw.flush();
        bw.close();
        br.close();
    }

    static void simule(int r, int c, int d) {
        while (true) {
//    현재 칸이 아직 청소되지 않은 경우, 현재 칸을 청소한다.
            if (map[r][c] == 0) {
                map[r][c] = 2;
                ans++;
            }
            boolean unClean = false;
            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (nr < n && nr >= 0 && nc < m && nc >= 0) {
                    if (map[nr][nc] == 0) {
                        unClean = true;
                        break;
                    }
                }
            }
//    현재 칸의 주변 $4$칸 중 청소되지 않은 빈 칸이 없는 경우,
            if (!unClean) {
                //바라보는 방향을 유지한 채로 한 칸 후진할 수 있다면 한 칸 후진하고 1번으로 돌아간다.
                int backR = r + dr[(d + 2) % 4];
                int backC = c + dc[(d + 2) % 4];
                if (map[backR][backC] != 1) {
                    if (backR < n && backC < m) {
                        r = backR;
                        c = backC;
                    }

                } else { //바라보는 방향의 뒤쪽 칸이 벽이라 후진할 수 없다면 작동을 멈춘다.
                    break;
                }
            } else {
                //현재 칸의 주변 $4$칸 중 청소되지 않은 빈 칸이 있는 경우,
                //반시계 방향으로 90도 회전한다.
                d = (d + 3) % 4;
                int nr = r + dr[d];
                int nc = c + dc[d];
                //바라보는 방향을 기준으로 앞쪽 칸이 청소되지 않은 빈 칸인 경우 한 칸 전진한다.
                if (map[nr][nc] == 0) {
                    if( nr < n && nc < m ){
                        r = nr;
                        c = nc;
                    }
                }
            }

        }

    }
}

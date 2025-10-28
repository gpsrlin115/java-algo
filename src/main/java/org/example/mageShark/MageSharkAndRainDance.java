package org.example.mageShark;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class MageSharkAndRainDance {
    static int N, M;
    static int[][] water;
    static int[] dr = {0, -1, -1, -1, 0, 1, 1, 1};
    static int[] dc = {-1, -1, 0, 1, 1, 1, 0, -1};
    static List<Cloud> clouds;
    static boolean[][] visitedCloud;
    private static int[] diagR = {-1, -1, 1, 1}; //대각선의 물복스버그
    private static int[] diagC = {-1, 1, -1, 1};

    static class Cloud {
        int r;
        int c;

        Cloud(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        water = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                water[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        clouds = new ArrayList<>();
        clouds.add(new Cloud(N - 1, 0));
        clouds.add(new Cloud(N - 1, 1));
        clouds.add(new Cloud(N - 2, 0));
        clouds.add(new Cloud(N - 2, 1));

        for (int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken())-1;
            int s = Integer.parseInt(st.nextToken())-1;

            moveClouds(d, s);

            rain();

            waterCopyBug();

            makeNewClouds();
        }
        System.out.println(sumWater());
    }

    private static void moveClouds(int d, int s) {
        for (Cloud cl : clouds) {
            cl.r = (cl.r + dr[d] * s) % N;
            cl.c = (cl.c + dc[d] * s) % N;

            if (cl.r < 0)
                cl.r += N;
            if (cl.c < 0)
                cl.c += N;
        }
    }

    private static void rain() {
        visitedCloud = new boolean[N][N];   // 매 턴 초기화
        for (Cloud cl : clouds) {
            water[cl.r][cl.c]++;
            visitedCloud[cl.r][cl.c] = true; // 이번 턴에 비가 내린 칸 표시
        }
    }

    private static int sumWater() {
        int sum = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sum += water[i][j];
            }
        }
        return sum;
    }

    private static void waterCopyBug() {
        for (Cloud cl : clouds) {
            int r = cl.r;
            int c = cl.c;
            int count = 0;

            for (int d = 0; d < 4; d++) {
                int nr = r + diagR[d];
                int nc = c + diagC[d];

                if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
                    if (water[nr][nc] > 0)
                        count++;
                }
            }

            water[r][c] += count;
        }
    }

    private static void makeNewClouds() {
        List<Cloud> newClouds = new ArrayList<>();

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                // 이번 턴에 구름이 없었고, 물의 양이 2 이상이면 새 구름 생성
                if (!visitedCloud[r][c] && water[r][c] >= 2) {
                    water[r][c] -= 2;
                    newClouds.add(new Cloud(r, c));
                }
            }

        }
        clouds = newClouds; // clouds 리스트를 새로운 구름으로 교체
    }
}

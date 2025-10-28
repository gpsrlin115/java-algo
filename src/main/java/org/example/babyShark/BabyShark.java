package org.example.babyShark;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BabyShark {

    static int N;
    static int[][] board;
    static boolean[][] visited;
    static int[] dr = {-1, 0, 0, 1};
    static int[] dc = {0, -1, 1, 0};

    static Shark shark;

    static class Shark {
        int r, c;
        int size;
        int eatCount;

        Shark(int r, int c) {
            this.r = r;
            this.c = c;
            this.size = 2;
            this.eatCount = 0;
        }
    }

    static class Fish{
        int r, c, dist;

        Fish(int r, int c, int dist) {
            this.r = r;
            this.c = c;
            this.dist = dist;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] == 9) {
                    shark = new Shark(i, j);
                    board[i][j] = 0;
                }
            }
        }

        int time = 0;

        while (true) {
            Fish target = bfs();
            if (target == null) break;

            // 상어 이동
            shark.r = target.r;
            shark.c = target.c;
            time += target.dist;

            // 물고기 먹기
            board[target.r][target.c] = 0;
            shark.eatCount++;
            if (shark.eatCount == shark.size) {
                shark.size++;
                shark.eatCount = 0;
            }
        }

        System.out.println(time);
    }

    // BFS로 먹을 수 있는 물고기 중 가장 우선순위 높은 것을 찾기
    static Fish bfs() {
        visited = new boolean[N][N];
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{shark.r, shark.c, 0});
        visited[shark.r][shark.c] = true;

        List<Fish> candidates = new ArrayList<>();

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0];
            int c = cur[1];
            int dist = cur[2];

            if (board[r][c] > 0 && board[r][c] < shark.size) {
                candidates.add(new Fish(r, c, dist));
            }

            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];
                if (nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
                if (visited[nr][nc]) continue;
                if (board[nr][nc] > shark.size) continue;

                visited[nr][nc] = true;
                q.offer(new int[]{nr, nc, dist + 1});
            }
        }

        if (candidates.isEmpty()) return null;
        return candidates.get(0);
    }
}

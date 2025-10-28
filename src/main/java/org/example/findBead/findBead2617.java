package org.example.findBead;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class findBead2617 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        boolean[][] graph = new boolean[n + 1][n + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int heavy = Integer.parseInt(st.nextToken());
            int light = Integer.parseInt(st.nextToken());
            graph[heavy][light] = true; // heavy > light
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (graph[i][k] && graph[k][j]) {
                        graph[i][j] = true;
                    }
                }
            }
        }

        int answer = 0;
        int middle = (n + 1) / 2;

        for (int i = 1; i <= n; i++) {
            int heavierCount = 0; // i보다 무거운 구슬의 개수
            int lighterCount = 0; // i보다 가벼운 구슬의 개수

            for (int j = 1; j <= n; j++) {
                if (graph[j][i]) {
                    heavierCount++; // j > i
                }
                if (graph[i][j]) {
                    lighterCount++; // i > j
                }
            }

            // 중간값이 될 수 없는 경우 체크
            if (heavierCount >= middle || lighterCount >= middle) {
                answer++;
            }
        }

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
        br.close();
    }
}

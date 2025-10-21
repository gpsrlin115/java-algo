package org.example.calender;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class calender20207 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] board = new int[n][366];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            for (int j = s; j <= e; j++) { // j: 1..365
                int index = 0;
                while (index < n && board[index][j] != 0) { // ★ 경계 체크
                    index++;
                }
                if (index == n) {
                    // 이 열(j)은 모든 층이 이미 찼음 → 정책 결정: 스킵/에러/확장
                    // 여기선 스킵
                    continue;
                }
                board[index][j] = 1;
            }
        }
        Queue<int[]> heights = columnCheck(board[0]);
        int totalArea = 0;
        while(!heights.isEmpty()){
            int[] arr = heights.poll();
            int start = arr[0], end = arr[1];
            int length = end-start+1;
            int height = 0;
            for(int row = 0; row<board.length; row++) {
                boolean hasOne = false;
                for (int col = start; col <= end; col++) {
                    if (board[row][col] == 1) {
                        hasOne = true;
                        break;
                    }
                }
                if (hasOne) {
                    height++;
                } else {
                    break;
                }
            }
            int area = length * height;
            totalArea += area;
        }
        System.out.println(totalArea);
    }

    private static Queue<int[]> columnCheck(int[] row) {
        int start = 0;
        Queue<int[]> queue = new ArrayDeque<>();

        for (int i = 1; i < row.length; i++) {
            if (row[i] == 1 && start == 0)
                start = i;
            if (start != 0 && row[i] == 0) {
                queue.offer(new int[] { start, i - 1 });
                start = 0;
            }
        }

        if (start != 0)
            queue.offer(new int[] { start, row.length - 1 });
        return queue;
    }

}

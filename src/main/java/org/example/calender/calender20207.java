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

        int[][] board = new int[n][365];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int index = 0;
            for (int j = s; j <= e; j++) {
                if (board[index][j] == 0) {
                    board[index][j] = 1;
                } else {
                    while (board[index][j] != 0) {
                        index++;
                    }
                    board[index][j] = 1;
                }
            }

        }
        Queue<int[]> heights = columnCheck(board[0]);
        for (int i = 0; i < heights.size(); i++) {
            int[] arr = heights.poll();
            System.out.println(Arrays.toString(arr));
        }
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
            queue.offer(new int[] { start, row.length - 1 }); // 끝 처리
        return queue;
    }

}

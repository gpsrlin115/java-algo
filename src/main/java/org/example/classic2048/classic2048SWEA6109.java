package org.example.classic2048;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class classic2048SWEA6109 {
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int n;
    static int[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            String direction = st.nextToken();
            board = new int[n][n];
            if (n == 1) {
                System.out.printf("#%d\n", tc);
                System.out.println(br.readLine());
                continue;
            }
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    board[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            simule(direction);
            System.out.printf("#%d\n", tc);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(board[i][j]);
                    if (j != n - 1) {
                        System.out.print(" ");
                    } else if (j == n - 1) {
                        System.out.println();
                    }
                }
            }
        }
    }

    public static void simule(String dir) {
        int[][] changed = new int[n][n];

        if (dir.equals("up")) {
            for (int j = 0; j < n; j++) {
                for (int i = 0; i < n-1; i++) {
                    if (board[i][j] == 0) continue;
                    int k = i + 1;
                    while (k < (n - 1) && board[k][j] == 0) k++;
                    if (board[i][j] == board[k][j]) {
                        board[i][j] += board[k][j];
                        board[k][j] = 0;
                    }
                }
                int idx = 0;
                for(int i = 0; i<n; i++){
                    if(board[i][j]!=0) changed[idx++][j]=board[i][j];
                }
            }
        } else if (dir.equals("down")) {
            for (int j = 0; j<n; j++){
                for(int i = n-1; i>0; i--){
                    if(board[i][j]==0) continue;
                    int k = i-1;
                    while(k>0 && board[k][j]==0) k--;
                    if(board[i][j] == board[k][j]){
                        board[i][j] += board[k][j];
                        board[k][j] = 0;
                    }
                }
                int idx = n-1;
                for(int i = n-1; i>=0; i--){
                    if(board[i][j]!=0) changed[idx--][j] = board[i][j];
                }
            }
        } else if (dir.equals("right")) {
            for (int i = 0; i<n; i++) {
                for (int j = n - 1; j > 0; j--) {
                    if (board[i][j] == 0) continue;
                    int k = j-1;
                    while(k>0 && board[i][k]==0) k--;
                    if(board[i][j]==board[i][k]){
                        board[i][j]+=board[i][k];
                        board[i][k]=0;
                    }
                }
                int idx = n - 1;
                for (int c = n - 1; c >= 0; c--) {
                    if(board[i][c]!=0) changed[i][idx--]=board[i][c];
                }
            }
        } else if (dir.equals("left")) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n - 1; j++) {
                    if(board[i][j]==0) continue;
                    int k = j+1;
                    while(k<n-1 && board[i][k]==0) k++;
                    if (board[i][j] == board[i][k]) {
                        board[i][j] += board[i][k];
                        board[i][k] = 0;
                    }

                }
                int idx = 0;
                for(int j=0; j<n; j++){
                    if(board[i][j]!=0) changed[i][idx++] = board[i][j];
                }
            }
        }
        board = changed;
    }
}

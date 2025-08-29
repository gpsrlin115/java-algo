package org.example.makeColoredPaper;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class MakeColoredPaper2630 {
    static int[][] board;
    static int whiteCount;
    static int blueCount;
    static int temp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        board = new int[N][N];
        for(int i = 0; i<N; i++){
            st=new StringTokenizer(br.readLine());
            for(int j = 0; j<N; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        divide(0, 0, board.length);
        bw.write(String.valueOf(whiteCount));
        bw.newLine();
        bw.write(String.valueOf(blueCount));
        bw.flush();
        bw.close();
        br.close();
    }
    static void divide(int r, int c, int size){
        if(colorCheck(r, c, size)==1){
            blueCount++;
            return;
        }else if (colorCheck(r, c, size) == 0) {
            whiteCount++;
            return;
        }
        
        int half = size / 2;
        divide(r,c, half);
        divide(r+half, c, half);
        divide(r,c+half, half);
        divide(r+half, c+half, half);
    }

    static int colorCheck(int r, int  c, int size){
        int prev = board[r][c];
        for (int i = r; i<r+size; i++){
            for(int j = c; j<c+size; j++){
                if(i == r && j == c){
                    continue;
                }
                if(board[i][j] != prev){
                    return -1;
                }
                prev = board[i][j];
            }
        }
        if (prev == 1){
            return 1;
        }
        return 0;
    }
}

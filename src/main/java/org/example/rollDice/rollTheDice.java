package org.example.rollDice;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

//14499
public class rollTheDice {
    static int n,m,x,y,k;
    static int[][] map;
    static Queue<Integer> move;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        map = new int[n][m]; //주사위가 있는곳은 0 => 0이 입력된칸부터 스타트. 
        for(int i =0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        move = new ArrayDeque<>();
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<k; i++){
            move.offer(Integer.parseInt(st.nextToken()));
        }
        
    }
}

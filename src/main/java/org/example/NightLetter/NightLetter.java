package org.example.NightLetter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class NightLetter {
    static int N,Q;
    static int[][] graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        Q = Integer.parseInt(br.readLine());
        graph = new int[N+1][N+1];
        StringTokenizer st;
        for(int i=1;i<=N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1;j<=N;j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int k = 1; k<=N; k++){
            for(int i = 1; i<=N; i++){
                for(int j = 1; j<=N; j++){
                    graph[i][j] = Math.min(graph[i][j], graph[i][k]+graph[k][j]);
                }
            }
        }

        for (int q = 0; q < Q; q++) {
            st = new StringTokenizer(br.readLine());
            int C = Integer.parseInt(st.nextToken());
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            int answer = cal(C, S, E);
            bw.write(answer + "\n");
        }
    }
    static int cal(int C, int S, int E){
        int answer = 0x3f3f3f3f;

        for(int )
    }
}

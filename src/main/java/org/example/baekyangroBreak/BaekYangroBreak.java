package org.example.baekyangroBreak;

import java.io.*;
import java.util.StringTokenizer;

public class BaekYangroBreak {
    static int n,m;
    static int max = 0x3f3f3f3f;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int[][] graph = new int[n+1][n+1];
        for(int i = 1; i<=n; i++){
            for(int k =1; k<=n; k++){
                if(i!=k){
                    graph[i][k] = max;
                }
            }
        }
        for(int i =0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[u][v] = 0;
            graph[v][u] =  (b==0) ? 1:0;
        }

        for(int k =1; k<=n; k++){
            for (int i = 1; i <=n; i++){
                for(int j = 1; j <=n; j++){
                    if(i == j){
                        continue;
                    }
                    if(graph[i][j]>graph[i][k]+graph[k][j]){
                        graph[i][j] = graph[i][k]+graph[k][j];
                    }
                }
            }
        }
        int k = Integer.parseInt(br.readLine());
        while(k-- > 0){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            bw.write(String.valueOf(graph[s][e]));
            bw.newLine();
        }
        bw.flush();
        bw.close();
        br.close();
    }
}


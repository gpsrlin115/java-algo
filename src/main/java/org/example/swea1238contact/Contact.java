package org.example.swea1238contact;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Contact {
    public static int[][] graph;
    public static int[] visited;
    public static int dataLength;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        for (int tc = 1; tc<=10; tc++){
            st = new StringTokenizer(br.readLine());
            dataLength = Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken());
            graph = new int[101][101];
            visited = new int[101];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i<dataLength/2; i++){
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());

                graph[from][to] = 1;
            }
            
            int result = bfs(start, 0);
            bw.write("#"+String.valueOf(tc)+" "+String.valueOf(result));
            bw.newLine();
            bw.flush();
            
        }
        bw.close();
        br.close();
    }

    public static int bfs(int start, int depth){
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        depth++;
        visited[start] = depth;
        
        while(!q.isEmpty()){
            start = q.poll();
            for(int i = 0; i<=100; i++){
                if(graph[start][i]==1 && depth==0){
                    q.offer(i);
                    visited[i] = visited[start]+1;
                }
            }
            depth = Math.max(depth, visited[start]);
        }

        for (int i = 100; i>=0; i--){
            if(visited[i]==depth){
                return i;
            }
        }

        return -1;
    }
}

package org.example.BFSDFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class DfsBfs {
    static List<Integer>[] graph;
    static boolean[] visited;
    static BufferedWriter bw;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());
        graph = new ArrayList[N+1];
        for(int i=0; i<=N; i++){
            graph[i] = new ArrayList<>();
        }
        
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());

            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            graph[parent].add(child);
            graph[child].add(parent);
        }
        for(int i = 1; i<=N; i++){
            Collections.sort(graph[i]);
        }
        visited = new boolean[N+1];
        dfs(V);
        visited = new boolean[N+1];
        bfs(V);
        bw.flush();
        br.close();
        bw.close();
    }


    static void dfs(int start) throws IOException{

        visited[start] = true;
        bw.write(String.valueOf(start)+ " ");
        
        for (int i : graph[start]) {
            if(!visited[i]){
                dfs(i);
            }
        }

    }
    static void bfs(int start) throws IOException{
        
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(start);
        visited[start] = true;
        while(!q.isEmpty()){
            int a = q.poll();
            bw.write(String.valueOf(a)+" ");
            bw.flush();
            if(!visited[a]){
                q.offer(a);
            }
        }
    }
}

package org.example.dfsandbfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BfsAndDfs {

    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st=new StringTokenizer("");
    static ArrayList<Integer>[] graph; //배열안에 Integer 형을 담는 ArrayList
    static boolean[] visited;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st =new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());
        graph=new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new  ArrayList<>();
        }
        //맵 만들기
        for (int i = 1; i <= M; i++) {
            st =new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph[x].add(y); //x의 인접
            graph[y].add(x); //y의 인접
        }
        for  (int i = 1; i <= N; i++) {
            Collections.sort(graph[i]); // 방문할 수 있는 정점이 여러 개인 경우 정점 번호가 작은 것부터 방문
        }
        visited = new boolean[N+1];
        dfs(V);
        bw.newLine();
        visited = new boolean[N+1];
        bfs(V);
        bw.newLine();
        bw.flush();
        bw.close();
        br.close();
    }
    static void dfs(int v) throws IOException {
        visited[v]=true; //방문 배열에 방문한 기록 저장
        bw.write(String.valueOf(v)+" ");
        for(int w:graph[v]){ //방문한 인덱스에 있는 자식 노드들
            if(!visited[w]){ //방문한 상태가 아니라면
                dfs(w); // 스택에 쌓기
            }
        }
    }
    static void bfs(int v) throws IOException{
        Queue<Integer> q=new LinkedList<>(); // 큐를 만들어서
        visited[v]=true; //
        q.offer(v);
        while(!q.isEmpty()){
            int now = q.poll();
            bw.write(String.valueOf(now)+" ");
            for(int i:graph[now]){
                if(!visited[i]){
                    visited[i]=true;
                    q.offer(i);
                }
            }
        }
    }

}

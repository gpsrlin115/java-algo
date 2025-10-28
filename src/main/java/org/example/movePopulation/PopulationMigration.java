package org.example.movePopulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class PopulationMigration {
    static int n,l,r,countDay;
    static int[][] arr;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static boolean[][] v;
    static class Node{
        int x;
        int y;
        Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        arr = new int[n][n];
        for(int i =0; i<n; i++){
            st=new StringTokenizer(br.readLine());
            for(int j = 0; j<n; j++){
                arr[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        v = new boolean[n][n];
        bfs(new Node(0,0));
        System.out.println(countDay);
    }
    public static void bfs(Node node){
        Queue<Node> q = new ArrayDeque<>();
        q.offer(node);
        int result = 0;
        int check = 0;
        int failedCheck = 0;
        while(!q.isEmpty()) {
            Node now = q.poll();
            int x = now.x;
            int y = now.y;
            for (int i = 0; i < 4; i++) {
                int nr = y + dr[i];
                int nc = x + dc[i];
                if (nr >= 0 && nr < n && nc >= 0 && nc < n) {
                    if (v[nr][nc] != true) {
                        int a = arr[y][x] - arr[nr][nc];
                        if (l <= a && a <= r) {
                            v[nr][nc] = true;
                            q.offer(new Node(nr,nc));
                        }
                    } else{
                        failedCheck++;
                    }
                }
            }
        }
        if (failedCheck == n*n){
            return;
        }
        for(int i =0; i<n; i++){
            for (int j = 0; j<n; j++){
                if(v[i][j]==true){
                    result+=arr[i][j];
                    check++;
                }
            }
        }
        if (check == 0){
            return;
        } else {
            result = result/check;
        }
        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                if(v[i][j]==true){
                    arr[i][j] = result;
                }
            }
        }
        v = new boolean[n][n];
        countDay++;
    }
}

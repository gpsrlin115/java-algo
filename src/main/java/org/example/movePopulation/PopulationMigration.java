package org.example.movePopulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class PopulationMigration {
    static int n,l,r;
    static int[][] arr;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static boolean[][] v;

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
        int days = 0;
        while(true){
            v = new boolean[n][n];
            boolean moved = false;
            for(int i = 0; i<n; i++){
                for(int j = 0; j<n; j++){
                    if(!v[i][j]){
                        int unionSize = bfs(i,j);
                        if (unionSize>1) moved = true;
                    }
                }
            }
            if(!moved) break;
            days++;
        }
        System.out.println(days);
    }
    public static int bfs(int sr, int sc){
        Queue<int[]> q = new ArrayDeque<>();

        List<int[]> coordinate = new ArrayList<>(); // 연합 좌표
        q.offer(new int[]{sr,sc});
        int sum = arr[sr][sc];
        v[sr][sc]=true;
        coordinate.add(new int[]{sr,sc});
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int r0 = cur[0];
            int c0 = cur[1];
            for (int i = 0; i < 4; i++) {
                int nr = r0 + dr[i];
                int nc = c0 + dc[i];
                if (nr < 0 || nr >= n || nc < 0 || nc >= n) continue;
                if(v[nr][nc]) continue;

                int diff = Math.abs(arr[r0][c0] - arr[nr][nc]);
                if(diff>=l && diff <= r){
                    v[nr][nc]=true;
                    q.offer(new int[]{nr,nc});
                    coordinate.add(new int[]{nr,nc});
                    sum+=arr[nr][nc];
                }
            }
        }
        if (coordinate.size()<=1) return 1; //이동없다

        int avg = sum/coordinate.size();
        for(int[] p : coordinate){
            arr[p[0]][p[1]] = avg;
        }
        return coordinate.size();
    }
}

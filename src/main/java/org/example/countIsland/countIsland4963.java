package org.example.countIsland;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class countIsland4963 {
    static int[][] arr;
    static boolean[][] visited;
    static int[] dx = {-1,-1,-1,0,0,0,1,1,1};
    static int[] dy = {-1,0,1,1,0,-1,-1,0,1};
    static int h;
    static int w;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while(true){
            String[] str = br.readLine().split(" ");
            w = Integer.parseInt(str[0]);
            h = Integer.parseInt(str[1]);

            arr = new int[h][w];
            // 마지막은 0/0이 주어진다.
            if(w == 0 && h == 0){
                break;
            }

            for (int i = 0; i<h; i++){
                String tempStr = br.readLine();
                String[] nums = tempStr.split(" ");
                for (int j = 0; j<w; j++){
                    arr[i][j] = Integer.parseInt(nums[j]);
                }
            }

            int count = 0;
            visited =  new boolean[h][w];
            for(int i = 0; i<h; i++){
                for(int j = 0; j<w; j++){
                    if(arr[i][j] == 1 && !visited[i][j]){
                        dfs(i, j);
                        count++;
                    }
                }
            }
            bw.write(count+"\n");
            bw.flush();
        }

        bw.close();
        br.close();
    }
    static void dfs(int i, int j){
        visited[i][j] = true;
        for (int a = 0; a<9; a++){
            int nx = i + dx[a];
            int ny = j + dy[a];

            if(nx>=0 && nx<h && ny>=0 && ny<w){
                if (arr[nx][ny] == 1 && !visited[nx][ny]){
                    dfs(nx, ny);
                }
            }
        }
    }
}
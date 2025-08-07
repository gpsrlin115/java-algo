package org.example.countIsland;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class countIsland4963 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] str = br.readLine().split(" ");
        int w = Integer.parseInt(str[0]);
        int h = Integer.parseInt(str[1]);

        int[][] arr = new int[w][h];

        for (int i = 0; i<w; i++){
            String tempStr = br.readLine();
            String[] nums = tempStr.split(" ");
            for (int j = 0; j<h; j++){
                arr[i][j] = Integer.parseInt(nums[j]);
            }
        }

        int count = 0;

        for(int i = 0; i<w; i++){
            for(int j = 0; j<h; j++){
                if(map[i][j] == 1 && !visited[i][j]){
                    dfs(i, j);
                    count++;
                }
            }
        }

    }
}
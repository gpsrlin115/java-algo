package org.example.history;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class History1613 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int inf = 0x3f3f3f3f;
        int[][] map = new int[n+1][n+1];
        for(int i = 1; i<=n; i++){
            for(int j = 1; j<=n; j++){
                if(i==j){
                    map[i][j] = 0;
                }
                else{
                    map[i][j] = inf;
                }
            }
        }
        for(int i = 0; i<k; i++){
            st = new StringTokenizer(br.readLine());
            int a= Integer.parseInt(st.nextToken());
            int b= Integer.parseInt(st.nextToken());
            map[a][b] = Math.min(map[a][b], 1);
        }

        for(int o = 1; o<=n; o++){
            for(int i = 1; i<=n; i++){
                for(int j = 1; j<=n; j++){
                    map[i][j] = Math.min(map[i][j], map[i][o]+map[o][j]);
                }
            }
        }

        int s = Integer.parseInt(br.readLine());
        for(int i = 0; i<s; i++){
            st = new StringTokenizer(br.readLine());
            int a= Integer.parseInt(st.nextToken());
            int b= Integer.parseInt(st.nextToken());
            if(map[a][b] == map[b][a] && map[a][b]==inf){
                bw.write("0");
                bw.newLine();
            } else if(map[a][b]!=inf && map[b][a]==inf){
                bw.write("-1");
                bw.newLine();
            }else{
                bw.write("1");
                bw.newLine();
            }
            
        }
        bw.flush();
        bw.close();
        br.close();
    }
    
}

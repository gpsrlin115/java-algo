package org.example.algotemplate.Floyd;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Floyd2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        final int inf = 0x3f3f3f3f;
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[][] route = new int[n+1][n+1];
        int[][] dp = new int[n+1][n+1];
        for(int i =1; i<=n; i++){
            for(int j = 1; j<=n; j++){
                if(i==j){
                    dp[i][j]=0;
                    route[i][j]=0;
                } else{
                    dp[i][j]=inf;
                    route[i][j]=0;
                }

            }
        }
        StringTokenizer st;
        for(int i =0; i<m; i++){
            st= new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            dp[a][b] = Math.min(dp[a][b], c);
            route[a][b] = b;
        }
        for(int c = 1; c<=n; c++){
            for(int a = 1; a<=n; a++){
                for(int b = 1; b<=n; b++){
                    if(dp[a][c] != inf && dp[c][b] != inf){
                        if(dp[a][c]+dp[c][b]<dp[a][b]){
                            dp[a][b] = dp[a][c]+dp[c][b];
                            route[a][b] = route[a][c];
                        }
                    }
                }
            }
        }
        for(int i = 1; i<=n; i++){
            for(int j = 1; j<=n; j++){
                if(dp[i][j]==inf){
                    bw.write("0 ");
                    
                } else {
                    bw.write(dp[i][j]+ " ");
                }
            }
            bw.newLine();
        }
        bw.flush();
        for(int i = 1; i<=n; i++){//시작
            for(int j = 1; j<=n; j++){//끝
                if(route[i][j]==0){
                    bw.write("0");
                    bw.newLine();
                } else{
                    List<Integer> path = new ArrayList<>();
                    int current = i;
                    while(current != j){
                       path.add(current);
                       current = route[current][j];
                    }
                    path.add(j);

                    bw.write(String.valueOf(path.size()));
                    bw.newLine();
                    for(int k = 0; k<path.size(); k++){
                        bw.write(String.valueOf(path.get(k))+" ");
                    }
                    bw.newLine();
                }
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }    
}

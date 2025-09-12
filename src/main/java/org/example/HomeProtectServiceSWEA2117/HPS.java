package org.example.HomeProtectServiceSWEA2117;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class HPS {
    static int n,m,maxHouseCount;
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t<=T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            //운영 비용 = K * K + (K - 1) * (K - 1)
            //도시를 벗어난 영역에 서비스를 제공해도 운영 비용은 변경되지 않는다.
            //서비스제공 체크 -> 이익이 0이상 = M*집들의 개수 - 운영비용
            map = new int[n][n];
            for(int i = 0; i<n; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j<n; j++){
                    map[i][j]= Integer.parseInt(st.nextToken());
                }
            }
            maxHouseCount =0;
            for (int r =0; r<n; r++){
                for(int c = 0; c<n; c++){
                    for(int k = 1; k<=n+1; k++){
                        int cost = k*k+(k-1)*(k-1);
                        int houseCount = countHouses(r,c,k);
                        int revenue = houseCount *m;
                        if(revenue>=cost){
                            maxHouseCount = Math.max(maxHouseCount, houseCount);
                        }
                    }
                }
            }
            System.out.println("#"+t+" "+maxHouseCount);
        }
    }

    static int countHouses(int r, int c, int k){
        int count =0 ;
        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                if(Math.abs(r-i)+Math.abs(c-j)<k){
                    if(map[i][j]==1){
                        count++;
                    }
                }
            }
        }
        return count;
    }
}
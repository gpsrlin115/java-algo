package org.example.treeGrow;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class treeGrowSWEA {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int tc = Integer.parseInt(br.readLine());
        for(int t = 1; t<=tc; t++){
            int n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            int[] tree = new int[n];;
            int tallest = Integer.MIN_VALUE;
            for(int i =0; i<n; i++){
                tree[i]=Integer.parseInt(st.nextToken());
                tallest = Math.max(tallest, tree[i]);
            }
            int ans = 0;
            ans = watering(tallest,n,tree);
            System.out.println("#"+t+" "+ans);
        }
    }
    static int watering(int tallest, int n, int[] tree){
        int days = 0, ones = 0, twoes = 0;
        for(int i = 0; i<n; i++){
            int diff = tallest - tree[i];
            if(diff==0) continue;
            twoes += diff/2;
            ones += diff%2;
        }
        //공통으로 커야하는 날 제외
        int mins = Math.min(ones, twoes);
        ones -=mins;
        twoes-=mins;
        //뺀 날 만큼 days +=
        days+=mins*2;
        //2일씩 커야되는 날이 0, 다시말해 홀수날 커야되는 날만 남으면
        /*
            1cm남았을 경우 1일
            2cm남았을 경우 3일
            3cm남았을 경우 5일
            4cm남았을 경우 7일
            f(n) = 2n-1
         */
        if(twoes==0){
            days += 2*ones-1;
        }
        if(ones==0){
            days+= twoes+1+(twoes-1)/3;
        }
        return days;
    }
}

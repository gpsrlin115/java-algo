package org.example.getRank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class GetRank {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int newScore = Integer.parseInt(st.nextToken());
        int top = Integer.parseInt(st.nextToken());
        int[] scores = new int[n];

        if(n>0){
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i<n; i++){
                scores[i] = Integer.parseInt(st.nextToken());
            }
        }
        if(n==top && newScore<= scores[n-1]){
            System.out.println(-1);
            return;
        }
        int rank  = 1;
        for (int i = 0; i<n; i++){
            if(scores[i]>newScore){
                rank++;
            } else {
                break;
            }
        }
        System.out.println(rank);
    }

}

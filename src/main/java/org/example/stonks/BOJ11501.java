package org.example.stonks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11501 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc<=T; tc++){
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];

            int answer = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 0; i<n; i++){
                arr[i]=Integer.parseInt(st.nextToken());
            }
            int max = arr[n-1];
            for(int i = n-2; i>=0; i--){
                if(max<arr[i]){
                    max = arr[i];

                }else {
                    answer += max - arr[i];
                }
            }
            System.out.println(answer);
        }
    }
}

package org.example.bronze;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;


public class boj24262 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        
        int n = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int result = Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken());
            sb.append(result).append('\n');
        }
        
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
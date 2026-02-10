package org.example.waterBottle;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ1052Bit {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int ans =0;
        while(Integer.bitCount(n)>k){
            int lowest = n&-n;
            ans += lowest;
            n+=lowest;
        }
        bw.write(String.valueOf(ans));
        bw.flush();
        bw.close();
        br.close();
    }
}

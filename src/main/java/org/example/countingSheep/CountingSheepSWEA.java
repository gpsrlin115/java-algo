package org.example.countingSheep;

import java.io.*;

public class CountingSheepSWEA {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for(int test_case = 1; test_case<=T; test_case++){
            int n = Integer.parseInt(br.readLine());
            boolean[] seen = new boolean[10];
            int countSeen = 0;
            int cnt = 0;
            while (countSeen<10){
                cnt++;
                int current = n * cnt;

                while(current>0){
                    int digit = current % 10;
                    if(!seen[digit]){
                        seen[digit] = true;
                        countSeen++;
                    }
                    current /= 10;
                }
                if(n*cnt == 0 && !seen[0]){
                    seen[0] = true;
                    countSeen++;
                }
            }
            bw.write("#"+test_case+" "+countSeen);
            bw.flush();
        }
        bw.close();
        br.close();
    }
}

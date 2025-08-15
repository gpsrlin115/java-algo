package org.example.pickdots;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;

public class pickdots2190{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input[] = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        long A = Long.parseLong(input[1]);
        long B = Long.parseLong(input[2]);

        long[][] arr = new long[N][2];
        Set<Long> xPoint = new HashSet<>();
        Set<Long> yPoint = new HashSet<>();
        for(int i = 0; i < N; i++){
            String[] mapinput = br.readLine().split(" ");
            arr[i][0] = Long.parseLong(mapinput[0]);
            arr[i][1] = Long.parseLong(mapinput[1]);
            xPoint.add(arr[i][0]);
            yPoint.add(arr[i][1]);
        }
        int result = 0;
        for (Long x : xPoint) {
            for (Long y : yPoint) {
                int cnt = 0;
                for (int i = 0; i<N; i++){
                    if(arr[i][0] >= x && arr[i][1] >= y && arr[i][0] <= x + A &&  arr[i][1] <= y + B){
                        cnt++;
                    }
                }
                result = Math.max(result,cnt);
            }
        }
        bw.write(result+"\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
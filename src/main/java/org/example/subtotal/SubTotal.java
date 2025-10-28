package org.example.subtotal;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class SubTotal {
    static int N, S;
    static int[] arr;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        arr = new int[N];
        
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0, right = 0;
        int sum = 0;
        int minLength = Integer.MAX_VALUE;
        
        while(right < N) {
            sum += arr[right];
            while(sum >= S) {
                minLength = Math.min(minLength, right - left + 1);
                sum -= arr[left];
                left++;
            }
            right++;
        }

        if(minLength == Integer.MAX_VALUE) {
            bw.write("0\n");
        } else {
            bw.write(minLength + "\n");
        }
        
        bw.flush();
        bw.close();
        br.close();
    }
}

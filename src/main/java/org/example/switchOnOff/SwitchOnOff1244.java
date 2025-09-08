package org.example.switchOnOff;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class SwitchOnOff1244 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] switches = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i<=N; i++){
            switches[i] = Integer.parseInt(st.nextToken());
        }
        int students = Integer.parseInt(br.readLine());
        for(int i = 0; i<students; i++){
            st = new StringTokenizer(br.readLine());
            int gender = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());
            if(gender == 1){
                for(int j = 0; j<switches.length; j++){
                    if(j%num == 0 && j!=0){
                        switch(switches[j]){
                            case 1:
                                switches[j]=0;
                                break;
                            case 0:
                                switches[j]=1;
                                break;
                        }
                    }
                }
            } else {
                int left =num, right = num;
                while(left>1 && right<N && switches[left-1] == switches[right+1]){
                    left--;
                    right++;
                }
                for(int j = left; j<=right; j++){
                    switches[j]^=1;
                }
            }
        }

        for (int i = 1; i<=N; i++){
            bw.write(String.valueOf(switches[i])+" ");
            if(i%20 == 0){
                bw.newLine();
            }
            bw.flush();
        }
        bw.close();
        br.close();
        
    }
}

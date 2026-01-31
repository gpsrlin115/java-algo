package org.example.truck;

import java.io.*;
import java.util.*;

public class BOJ13335 {
        static int n,w,l,count; // n : 트럭대수 w: 다리위의 최대트럭 l:최대하중
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); // 트럭대수
        w = Integer.parseInt(st.nextToken()); // 다리 길이 이기도함.
        l = Integer.parseInt(st.nextToken()); //최대하중
        Queue<Integer> li = new ArrayDeque<>();
        st = new StringTokenizer(br.readLine());
        count = 0;
        for(int i = 0; i<n; i++){
            li.offer(Integer.parseInt(st.nextToken()));
        }
        count = simul(li);
        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
        br.close();
    }
    static int simul(Queue<Integer> li){
        Queue<Integer> bridge = new ArrayDeque<>();
        for(int i = 0; i < w; i++){
            bridge.offer(0);
        }
        int time = 0;
        int currentWeight = 0;

        while(!li.isEmpty()){
            time++;
            currentWeight-=bridge.poll();
            int nextTruck = li.peek();
            if(currentWeight + nextTruck <= l){
                int target = li.poll();
                bridge.offer(target);
                currentWeight+=target;
            } else{
                bridge.offer(0);
            }
        }
        return time+w;
    }
}

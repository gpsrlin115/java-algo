package org.example.eggbreakegg;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ16987 {
    public static class Egg {
        int duration;
        int weight;
        Egg(int duration, int weight){
            this.duration = duration;
            this.weight = weight;
        }
    }
    /* egg1.duration - egg2.weight
    egg2.duration - egg1.weight
    => if eggN.duration <=0 eggN.breaked = true;

    eggs[]
    pickegg = eggs[0]
    for(int i = 1; i<eggs.length; i++){
        if(eggs[i].breaked) continue;
        pickegg.duration - eggs[i].weight;
        if(pickegg.duration <=0) pickegg.breaked = true;
    }
     */
    static int n,answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        Egg[] eggs = new Egg[n];
        answer = 0;
        for(int i = 0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            eggs[i] = new Egg(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        if(n>0){
            solve(0, eggs);
        }
        System.out.println(answer);
    }

    static void solve(int idx, Egg[] eggs){
        if(idx == n){
            int count = 0;
            for(int i = 0; i<n; i++){
                if(eggs[i].duration<=0) count++;
            }
            answer = Math.max(answer, count);
            return;
        }
        if(eggs[idx].duration<=0) {
            solve(idx+1, eggs);
            return;
        }

        boolean hit = false;
        for(int i = 0; i<n; i++){
            //자기 자신, 이미 깨진 계란은 건너뛰기
            if(i == idx|| eggs[i].duration<=0) continue;
            hit = true;
            eggs[idx].duration -= eggs[i].weight;
            eggs[i].duration -= eggs[idx].weight;

            solve(idx+1, eggs);

            eggs[idx].duration += eggs[i].weight;
            eggs[i].duration += eggs[idx].weight;
        }
        if(!hit){
            solve(idx+1, eggs);
        }
    }
}

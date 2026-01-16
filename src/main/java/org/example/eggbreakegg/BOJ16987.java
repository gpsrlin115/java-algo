package org.example.eggbreakegg;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ16987 {
    public static class Egg {
        int duration;
        int weight;
        boolean breaked;
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
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Egg[] eggs = new Egg[n];
        for(int i = 0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            eggs[i] = new Egg(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            eggs[i].breaked = false;
        }
        int answer = 0;
        for(int i = 0; i<n; i++){
           Egg pickegg = eggs[i];
            for(int j = i+1; j<n; j++){
                if(eggs[j].breaked) continue;
                pickegg.duration -= eggs[j].weight;
                if(pickegg.duration <=0) pickegg.breaked = true;
                eggs[j].duration -= pickegg.weight;
                if(eggs[j].duration <=0) eggs[j].breaked = true;
            }
            int count = 0;
            for(int j = 0; j<n; j++){
                if(eggs[j].breaked) count++;
            }
            answer = Math.max(answer, count);
        }
        System.out.println(answer);
    }
}

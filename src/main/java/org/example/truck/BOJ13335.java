package org.example.truck;

import java.io.*;
import java.util.*;

public class BOJ13335 {
    static class Truck{
        int weight;
        int dist;

        Truck(int w, int d){
            this.weight = w;
            this.dist = d;
        }
    }
    static int n,w,l,count; // n : 트럭대수 w: 다리위의 최대트럭 l:최대하중
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine()); // 트럭대수
        w = Integer.parseInt(br.readLine()); // 다리 길이 이기도함.
        l = Integer.parseInt(br.readLine()); //최대하중
        Queue<Truck> li = new ArrayDeque<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        count = 0;
        for(int i = 0; i<n; i++){
            li.offer(new Truck(Integer.parseInt(st.nextToken()), w));
        }
        simul(li);
    }
    static void simul(Queue<Truck> li){
        List<Truck> bridge = new ArrayList<>();
        while(!li.isEmpty()){
            if(bridge.size()<w){
                bridge.add(li.poll());
            }
        }
    }
}

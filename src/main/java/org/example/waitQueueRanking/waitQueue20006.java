package org.example.waitQueueRanking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class waitQueue20006 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<Pair> waitQueue = new ArrayDeque<>();
        PriorityQueue<Pair> room = new PriorityQueue<>(); // 방 관리
        StringTokenizer st = new StringTokenizer(br.readLine());
        int p = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int levelCut = 0;
        for (int i = 0; i<p; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            String nickname = st.nextToken();

            if(room.isEmpty()){
                System.out.println("Started!");
                room.offer(new Pair(n, nickname));
            }
            if(m==1){
                Pair o = room.poll();
                System.out.println(o.lvl+" "+o.nickname);
            } else if(room.size() >=m){
                for(int j = 0; j<m; j++){
                    Pair out = room.poll();
                    System.out.println(out.lvl+" "+out.nickname);
                }
                if (!waitQueue.isEmpty()){
                    room.addAll(waitQueue);
                    System.out.println("Started!");
                }
                waitQueue.clear();
            }
            if(!room.isEmpty()&&i!=0){
                Pair firstM = room.peek();
                levelCut = firstM.lvl;
                if (levelCut-10<=n && levelCut+10>=n){
                    room.offer(new Pair(n, nickname));
                    if(i==p-1){
                        for(int j = 0; j<m; j++){
                            Pair out = room.poll();
                            System.out.println(out.lvl+" "+out.nickname);
                        }
                    }
                } else {
                    waitQueue.offer(new Pair(n, nickname));
                    System.out.println("Waiting!");
                }
            }
        }
    }

    static class Pair implements Comparable<Pair> {
        int lvl;
        String nickname;

        Pair(int lvl, String nickname) {
            this.lvl = lvl;
            this.nickname = nickname;
        }

        @Override
        public int compareTo(Pair o) {
            return this.nickname.compareTo(o.nickname);
        }
    }
}

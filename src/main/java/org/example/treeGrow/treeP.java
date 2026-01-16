package org.example.treeGrow;

import java.util.*;

public class treeP {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            int N = sc.nextInt();
            int[] trees = new int[N];

            int maxHeight = Integer.MIN_VALUE;
            for (int i = 0; i < N; i++) {
                trees[i] = sc.nextInt();
                maxHeight = Math.max(maxHeight, trees[i]);
            }

            // 각 나무가 얼마나 더 커져야 하는지 계산
            int totalOne = 0; // +1 성장 필요한 횟수
            int totalTwo = 0; // +2 성장 필요한 횟수

            for (int h : trees) {
                int diff = maxHeight - h;
                if(diff==0) continue;
                totalTwo += diff / 2;
                totalOne += diff % 2;
            }

            if(totalTwo>totalOne){
                while(Math.abs(totalTwo-totalOne)>1){
                    totalTwo--;
                    totalOne+=2;
                }
            }
            int day = 0;
            if(totalOne>totalTwo){
                day = totalOne*2-1;
            } else if(totalTwo>totalOne){
                day = totalTwo*2;
            } else{
                day = totalTwo+totalOne;
            }

            System.out.println("#" + tc + " " + day);
        }
    }
}


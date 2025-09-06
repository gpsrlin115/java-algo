package org.example.algotemplate;

import java.util.Arrays;

public class UnionFind {
    public static void main(String[] args) {
        int[] parent = new int[11]; //10+1 (0번은 사용 x)
        for(int i = 1; i<11; i++){
            parent[i] = i;
        }
        unionParent(parent, 1,2);
        unionParent(parent, 2,3);
        unionParent(parent, 3,4);
        unionParent(parent, 5,6);
        unionParent(parent, 7,8);
        System.out.println("1과 3은 연결 되어이있을까? "+findParent(parent, 1, 5));
        unionParent(parent, 1, 5);
        System.out.println("1과 5은 연결 되어이있을까? "+findParent(parent, 1, 5));
    }

    public static void unionParent(int[] parent, int a, int b) {
        // TODO Auto-generated method stub
        a = getParent(parent, a);
        b = getParent(parent, b);
        if(a<b) parent[b] = a;
        else parent[a] = b;
    }

    public static int getParent(int[] parent, int x) {
        // TODO Auto-generated method stub
        if(parent[x] == x) return x;
        return parent[x] = getParent(parent, parent[x]);
    }

    public static int findParent(int[] parent, int a, int b){
        a = getParent(parent, a);
        b = getParent(parent, b);
        if(a==b) return 1;
        else return 0;
    }
}

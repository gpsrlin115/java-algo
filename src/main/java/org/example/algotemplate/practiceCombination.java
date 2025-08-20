package org.example.algotemplate;

import java.util.Arrays;

public class practiceCombination {
    static int[] arr = {1,3,5};
    static int n = 2;
    public static int[] sel = new int[n];

    static void recursive(int idx, int k){
        if(k == n){
            System.out.println(Arrays.toString(sel));
            return;
        }
        if(idx == arr.length) return;
        sel[k] = arr[idx];
        recursive(idx+1, k+1);
        recursive(idx+1, k);
    }

    public static void main(String[] args) {
        
        recursive(0,0);
    }
}

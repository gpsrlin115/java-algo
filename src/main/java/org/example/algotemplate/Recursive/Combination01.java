package org.example.algotemplate.Recursive;

import java.util.Arrays;

public class Combination01 {
    static int N = 2;
    public static void main(String[] args) {
        int[] arr = {1,3,5};
        int[] sel = new int[N];
        /*
            arr 의 순서 idx
            sel 의 순서 k
         */
        recursive(arr, 0, sel, 0);
    }
    static void recursive(int[] arr, int idx, int[] sel, int k){
        if(k == N){
            System.out.println(Arrays.toString(sel));
            return;
        }
        if(idx==arr.length) return;
        sel[k] = arr[idx];
        recursive(arr, idx+1, sel, k+1);
        recursive(arr, idx+1, sel, k);
    }
}

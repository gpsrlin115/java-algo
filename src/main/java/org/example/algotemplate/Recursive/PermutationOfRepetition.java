package org.example.algotemplate.Recursive;

/*
 * 원본배열에 있는 모든 요소값을 고르는 재귀를 작성하세요
 * 상태공간트리 그리기
 * 순서 o , 중복 o (중복순열)
 *
 */

import java.util.Arrays;

public class PermutationOfRepetition {
    static int[] arr = {1,3,5,7};
    static int[] sel = new int[arr.length];

    public static void main(String[] args){
        recursive(0);
    }
    static void recursive(int idx){
        if(idx==arr.length){
            System.out.println(Arrays.toString(sel));
            return;
        }
        for(int i =0; i<arr.length; i++){
            sel[idx] = arr[i];
            recursive(idx+1);
        }
        //sel[idx] = arr[0];
//        recursive(idx+1);
//        sel[idx] = arr[1];
//        recursive(idx+1);
//        sel[idx] = arr[2];
//        recursive(idx+1);
    }
}

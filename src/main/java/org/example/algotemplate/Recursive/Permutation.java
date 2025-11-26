package org.example.algotemplate.Recursive;
/*
 * 원본배열에 있는 모든 요소값을 고르는 재귀를 작성하세요
 * 단 중복을 배재하세요
 * 상태공간트리 그리기 (순열)
 * 순서 o
 * 방문배열의 원리와 실행순서를 상태공간트리로 그려본다
 */

import java.util.Arrays;

public class Permutation {
    static int[] arr = {1,3,5};
    static int[] sel = new int[arr.length];
    static boolean[] v = new boolean[arr.length];

    public static void main(String[] args) {
        recursive(0);
    }
    static void recursive(int idx){
        if(idx == arr.length){
            System.out.println(Arrays.toString(sel));
            return;
        }
        for(int i = 0; i<arr.length; i++){
            if(v[i]==false){
                v[i]=true;
                sel[idx] = arr[i];
                recursive(idx+1);
                v[i]=false;
            }
        }
//
//        if(v[0]==false){
//            v[0] = true;
//            sel[idx] = arr[0];
//            recursive(idx+1);
//            v[0] = false;
//        }
//        if(v[1]==false){
//            v[1] = true;
//            sel[idx] = arr[1];
//            recursive(idx+1);
//            v[1]=false;
//        }
//        if(v[2]==false){
//            v[2]=true;
//            sel[idx] = arr[2];
//            recursive(idx+1);
//            v[2]=false;
//        }

    }
}

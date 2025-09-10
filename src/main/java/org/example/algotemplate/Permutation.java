package org.example.algotemplate;

public class Permutation {
    public static void main(String[] args) {
        int[] arr = {1,2,3};
        int n = arr.length; // 배열의 길이
        int r = 2; //뽑을 개수

        System.out.println(n+"개 에서 "+r+"개를 뽑는 순열 : ");
        permutation(arr, 0, n, r);
    }
    /**
     * 순열을 구하는 재귀
     * @param arr : 순열 배열
     * @param idx : 현재 재귀의 깊이 (몇번째 자리를 채우고 있는지)
     * @param n : 배열의 전체 길이
     * @param r : 뽑고자 하는 순열의 길이
     */
    public static void permutation(int[] arr, int idx, int n, int r){
        if(idx == r){
            for(int i = 0; i<r; i++){
                System.out.println(arr[i]+" ");
            }
            System.out.println();
            return;
        }
        for (int i = idx; i<n; i++){ //깊이부터 돌아야함
            int temp = arr[idx]; // 현재 깊이(depth)의 위치와 i 위치의 원소를 교환
            arr[idx] = arr[i];
            arr[i] = temp;
            permutation(arr, idx+1, n, r); // 다음레벨로 ㄱㄱ
            temp = arr[idx]; // 재귀 호출이 끝나면 원상복구 (백트래킹)
            arr[idx] = arr[i];
            arr[i] = temp;
        }
    }
}

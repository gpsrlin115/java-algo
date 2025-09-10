package org.example.algotemplate;

public class Subset {
    public static void main(String[] args) {
        int arr[] = {1,2,3};
        int n = arr.length;
        int r = 2;
        boolean[] visited = new boolean[n]; // 각 원소의 포함 여부를 저장

        System.out.println(n+"개의 원소로 만들 수 있는 부분집합들:");
        subset(arr, visited, 0);
    }

    /**
     * 부분집합을 구하는 재귀 함수
     * @param arr : 원본배열
     * @param visited : 각 원소의 포함 여부를 저장
     * @param idx : 현재 포함 여부를 결정할 원소의 인덱스
     */
    static void subset(int[] arr, boolean[] visited, int idx){
        if (idx == arr.length){
            for(int i = 0; i<arr.length; i++){
                System.out.println("{" + arr[i] + " " +"}");
            }
        }
        visited[idx] = false;
        subset(arr, visited, idx+1); //현재 원소(idx)를 포함하지 않는 경우

        visited[idx] = true; // 백 트래킹
        subset(arr, visited, idx+1);
    }
}
package org.example.algotemplate;

public class Combination {
    public static void main(String[] args) {
        int arr[] = {1,2,3};
        int n = arr.length;
        int r = 2;
        boolean[] visited = new boolean[n];

        System.out.println(n+"개에서"+r+"개를 뽑는 조합:");
        combination(arr, visited, 0, n, r);
    }
    
    static void combination(int[] arr, boolean[] visited, int start, int n, int r){
        if(r==0){
            for(int i = 0; i<n; i++){
                if(visited[i]){
                    System.out.print(arr[i]+" ");
                }
            }
            System.out.println();
        }
        for(int i = start; i<n; i++){
            visited[i] = true;
            combination(arr, visited, i+1, n, r-1);
            visited[i] = false; //원상복구 (백트래킹)
        }
    }
}

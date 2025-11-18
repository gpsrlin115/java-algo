package org.example.algotemplate.Recursive;

public class PowerSet {
    static int n = 3;

    public static void main(String[] args) {
        int[] arr= {1,3,5};
        boolean sel[] = new boolean[arr.length];
        recursive(arr, sel, 0);
    }
    static void recursive(int[] arr, boolean[] sel, int idx){
        if(idx == arr.length){
            for(int i = 0; i<sel.length; i++){
                if(sel[i]){
                    System.out.print(arr[i]+" ");
                }
            }
            System.out.println();
            return;
        }
        sel[idx] = true;
        recursive(arr, sel, idx+1);
        sel[idx] = false;
        recursive(arr, sel, idx+1);
    }
}

package org.example.algotemplate.Recursive;

public class Recursive02 {
    public static void main(String[] args) {
        recursive(1, 0, 1);
    }
    private static void recursive(int i, int sum, int cross){
        if(i>5){
            System.out.printf("%d %d", sum, cross);
            return;
        }

        recursive(i+1, sum+i, cross*i);
    }
}

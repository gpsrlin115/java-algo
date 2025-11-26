package org.example.algotemplate.Recursive;

/*
 * 1 ~ 10 까지 더하고 곱하는 코드를 재귀함수로 구현하세요
 * 단 함수의 인자를 2개만 사용하세요
 * 상태공간트리
 * 파생파트^기반파트 의 경우의 수가 반복된다
 */

public class Recursive03 {
    public static void main(String[] args) {
        recursive(1,1);
    }
    private static void recursive(int a, int b){
        if(a>3){
            System.out.printf("%d ", b);
            return;
        }
        recursive(a+1,a+b);
        recursive(a+1, a*b);
    }
}

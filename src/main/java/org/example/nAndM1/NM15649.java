package org.example.nAndM1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
/*
문제
자연수 N과 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.

1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열
입력
첫째 줄에 자연수 N과 M이 주어진다. (1 ≤ M ≤ N ≤ 8)

출력
한 줄에 하나씩 문제의 조건을 만족하는 수열을 출력한다. 중복되는 수열을 여러 번 출력하면 안되며, 각 수열은 공백으로 구분해서 출력해야 한다.

수열은 사전 순으로 증가하는 순서로 출력해야 한다.
 */
public class NM15649 {
    static boolean[] visited;
    static int [] sel;
    static int n;
    static int m;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        String[] st = br.readLine().split(" ");
        n = Integer.parseInt(st[0]);
        m = Integer.parseInt(st[1]);
        visited = new boolean[n+1];
        sel = new int[m];
        backtrack(0);
        bw.close();
        br.close();
    }

    static void backtrack(int depth) throws IOException{
        //basis
        if(depth == m){ // 재귀깊이가 M이 되면
            for(int i =0; i<m; i++){ //지금까지 저장한 배열을
                bw.write(sel[i]+" "); // 출력하고
            }
            bw.newLine();
            bw.flush();
            return; // 함수종료
        }

        //inductive
        //아직 안 사용한 숫자라면
        for(int i = 1; i<=n; i++){
            if(!visited[i]){
                sel[depth] = i; // 선택 배열에 i를 넣고
                visited[i] = true; //방문표시
                backtrack(depth+1);  //재귀호출
                visited[i] = false; // return되면 방문표시 해제
            }
        }
    }
}
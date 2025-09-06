package org.example.setPresent;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class SetPresent1717 {
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        parent = new int[N+1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }
        for (int i = 0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            //0은 합집합 연산.
            //1은 두 원소가 같은 집합에 있는지 확인
            int op =  Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(op == 0){
                Union(a,b);
            }
            else {
                if (find(a) == find(b)){
                    bw.write("YES");
                }
                else {
                    bw.write("NO");
                }
            }
            bw.newLine();
            bw.flush();
        }
        bw.close();
        br.close();
    }

    public static void Union(int a, int b){
        a = find(a);
        b = find(b);
        if (a != b){
            if (a < b){
                parent[b] = a;
            }
            else{
                parent[a] = b;
            }
        }
    }

    public static int find(int x){
        if(parent[x] == x){
            return x;
        }
        return parent[x] = find(parent[x]);
    }
}

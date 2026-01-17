package org.example.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
    *
    * @param
    * n : 인원수
    * t : 티셔츠
    * p : 펜 한 묶음 단위
 */
public class boj30802 {
    static int ans=0;
    static int penMult;
    static int penLeft;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n,t,p;
        int[] size = new int[6];

        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i<6; i++){
            size[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());

        t = Integer.parseInt(st.nextToken());
        p = Integer.parseInt(st.nextToken());
        for (int i : size) {
            ans += (i + t - 1) / t;
        }
        System.out.println(ans);
        penCalc(n,p);


    }
    static void penCalc(int n, int p){
        int pen = n;
        int penMult =0;
        while(pen>=p){
            pen-=p;
            penMult++;
        }
        penLeft=pen;
        System.out.println(penMult+" "+penLeft);
    }

}

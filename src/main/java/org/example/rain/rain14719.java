package org.example.rain;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class rain14719 {
    static int[] blocks;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        
        blocks = new int[W];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i<W; i++){
            blocks[i] = Integer.parseInt(st.nextToken());
        }
        map = new int[H][W];
        for(int i = 0; i<W; i++){
            for(int j = H-1; j>=0; j--){
                if(blocks[i]>0){
                    map[j][i]=1;
                    blocks[i]--;
                }
            }
        }
        
        int standard = blocks[0];
        bw.write(String.valueOf(sol(standard,H,W)));
        bw.flush();
        br.close();
        bw.close();
    }

    static int sol(int standard, int H, int W){
        int water = 0;
        
        for(int h = 0; h<H; h++){
            boolean[] isHole = new boolean[2];
            int a=0;
            int b=0;
            for (int w = 0; w<W; w++){
                if(map[h][w]==1&&isHole[0]==false){
                    isHole[0]=true;
                    a=w;
                } else if (map[h][w]==1&&isHole[0]&&!isHole[1]){
                    isHole[1]=true;
                    b=w;
                }
                if(isHole[0] && isHole[1]){
                    if (b-(a+1)==0) {
                        isHole[1] = false;
                        a=b;
                        b=0;
                        continue;
                    }
                    water += b-(a+1);
                    isHole[1] = false;
                    a=b;
                    b=0;
                }
            }
        }
        return water;
    }
}

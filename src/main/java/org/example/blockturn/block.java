package org.example.blockturn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class block {
    static void kkomsu(int N, int[] count, int[][] grid, BufferedReader br) throws IOException{
        
        for(int i = 0; i<N; i++){
            for(int j =0; j<count[i]; j++){
                grid[i][j]=1;
            }
        }
        for(int i = 0; i<N; i++){
            System.out.println(Arrays.toString(grid[i]));
        }       
    }
    static void index1(int N, int[] count, int[][] grid, BufferedReader br,int[][] origin) throws IOException{

        int[][] rotate = new int[N][N];
        for(int i = 0; i<N; i++){
            for (int j = 0; j<N; j++){
                rotate[j][N-1-i] = origin[i][j];
            }
        }
        for (int i = N; i > 0; i--) {
            for (int j = N; j>0; j--){
                //오른쪽에서 왼쪽으로 밑에서 위로 카운트 혹은 스왑.
            }
        }
        
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int[] count = new int[N];
        int[][] origin = new int[N][N];
        int[][] grid = new int[N][N];
        for(int i = 0; i<N; i++){
            String[] st = br.readLine().split(" ");
            int cnt =0;
            for(int j = 0; j<N; j++){
                origin[i][j] = Integer.parseInt(st[j]);
                if(st[j].equals("1")){
                    cnt+=1;
                }
            }
            count[i] = cnt;
        }
        kkomsu(N, count, grid, br);
        //index1(N, count, grid, br, origin);
    }
}


package org.example.sudoku;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//swea
public class sudoku1974 {
    static int[][] grid = new int[9][9];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/java/org/example/sudoku/input.txt")));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for(int test_case = 1; test_case<=T; test_case++){
            for(int str = 0; str<9; str++){
                String[] input_line = br.readLine().split(" ");
                for(int inside = 0; inside<9; inside++){
                    grid[str][inside]=Integer.parseInt(input_line[inside]);
                }
            }
            
            bw.write("#"+test_case+" "+check());
            bw.newLine();
            bw.flush();
        }
        bw.close();
        br.close();
    }

    static int check(){
        for(int i = 0; i<9; i++){
            boolean[] inside_visited = new boolean[10];
            boolean[] outside_visited = new boolean[10];
            for(int j = 0; j<9; j++){
                if(inside_visited[grid[i][j]]){
                    return 0;
                }
                inside_visited[grid[i][j]] = true;
                if(outside_visited[grid[j][i]]){
                    return 0;
                }
                outside_visited[grid[j][i]] = true;
            }
        }
        for (int i=0; i<9; i+=3){
            for(int j = 0; j<9; j+=3){
                boolean[] gridCheck = new boolean[10];
                for(int gy=i; gy<i+3; gy++){
                    for(int gx=j; gx<j+3; gx++){
                        if(gridCheck[grid[gy][gx]]){
                            return 0;
                        }
                        gridCheck[grid[gy][gx]]=true;
                    }
                }
            }
        }
        return 1;
    }
}

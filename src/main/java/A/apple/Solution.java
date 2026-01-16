package A.apple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static class Apple{
        int r;
        int c;

        Apple(int x , int y){
            this.r = x;
            this.c = y;
        }
    }
    static int n;
    static int[] dr = {0,1,0,-1}; //우 하 좌 상
    static int[] dc = {1,0,-1,0}; //우 하 좌 상
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        for(int t = 1; t<=tc; t++){
            n = Integer.parseInt(br.readLine());
            int[][] map = new int[n][n];
            Apple[] apples = new Apple[11];
            int appleCnt = 0;
            for(int i = 0; i<n; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j = 0; j<n; j++){
                    int input = Integer.parseInt(st.nextToken());
                    if(input > 0){
                        apples[input] = new Apple(i,j);
                        appleCnt = Math.max(appleCnt, input);
                    }
                    map[i][j] = input;
                }
            }
            int rotationCnt = 0;
            int currentR = 0, currentC=0;
            int currentDir=0;

            for(int appleNum =1; appleNum<=appleCnt; appleNum++){
                Apple target = apples[appleNum];
                while(currentR!= target.r|| currentC!= target.c){
                    int nextR = currentR+dr[currentDir];
                    int nextC = currentC+dc[currentDir];
                    if(!isValid(nextR, nextC) || !isMovingTowrdsTarget(currentR,currentC,nextR, nextC, target)){
                        currentDir = (currentDir+1)%4;
                        rotationCnt++;
                    } else {
                        currentR = nextR;
                        currentC = nextC;
                    }
                }

            }
            System.out.printf("#%d %d\n", t, rotationCnt);
        }
    }

    private static boolean isMovingTowrdsTarget(int currentR, int currentC, int nextR, int nextC, Apple target) {
        int currentDistance = Math.abs(currentR- target.r)  + Math.abs(currentC- target.c);
        int nextDistance = Math.abs(nextR- target.r)  + Math.abs(nextC- target.c);
        return nextDistance < currentDistance;
    }

    private static boolean isValid(int nextR, int nextC) {
        return nextR>=0 && nextR<n && nextC >=0 && nextC<n;
    }
}

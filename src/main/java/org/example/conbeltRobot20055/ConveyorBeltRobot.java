package org.example.conbeltRobot20055;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ConveyorBeltRobot {
    static int n,k;
    static boolean[] v;
    static int[] convey;
    static int idx = 0;
    static int end;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        convey = new int[(n*2)];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<convey.length; i++){
            convey[i]=Integer.parseInt(st.nextToken());
        }
        v = new boolean[n*2];
        end = n-1;
        int count = simule();
    }
    static int simule(){
        int count = 0; // 단계 횟수

        while(countEmptyDurability()<k){
            count++;
            if(v[idx]==false&&convey[idx]!=0){
                rotate();
                moveRobots();
                putRobot();
            }

        }

        return count;
    }
    static void rotate(){
        int temp = convey[(2*n)-1];
        for(int i = (n*2)-1; i>0; i--){
            convey[i] = convey[i-1];
        }
        convey[0] = temp;

        for(int i = n-1; n>0; i--){
            v[i]=v[i-1];
        }
        v[0]=false;
    }

    static void moveRobots(){
        
    }

    static void putRobot(){
        
    }

    static int countEmptyDurability(){
        int count = 0;//0 check
        for(int d : convey){
            if(d==0){
                count++;
            }
        }
        return count;
    }
}

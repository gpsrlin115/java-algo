package org.example.conveyorBeltOnRobot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ConveyorBeltOnRobot {
    static int[] conv;
    static boolean[] robot;
    static int n, k;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        conv = new int[n*2]; //zero-base
        robot= new boolean[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i<n*2; i++){
            conv[i]=Integer.parseInt(st.nextToken());
        }
        int a = 0;
        while(true){
            a++;
            rotate();

            robotWalk();

            robotSet();

            if (checkZero()) break;
        }
        System.out.println(a);
    }

    static void rotate(){
        int temp = conv[conv.length-1];
        for(int i = conv.length-1; i>0; i--){
            conv[i]=conv[i-1];
        }
        conv[0]=temp;

        // 로봇도 함께 회전
        for (int i = n - 1; i > 0; i--) {
            robot[i] = robot[i - 1];
        }
        robot[0] = false; // 새로 올라오는 자리는 비어있음

        robot[n-1] = false; //로봇이 내리는 벨트에 오면 하차.
    }
    static void robotWalk(){
        for(int i = n-2; i>=0; i--){
            if(robot[i] && !robot[i+1] && conv[i+1]>0){
                robot[i] = false;
                robot[i+1] = true;
                conv[i+1] -= 1;
            }
        }
        robot[n-1] = false;//로봇이 내리는 벨트에 오면 하차.
    }

    static void robotSet(){
        if (conv[0]>0){
            robot[0] = true;
            conv[0] -= 1;
        }
    }
    static boolean checkZero(){
        int count = 0;
        for(int i = 0 ; i<n*2; i++){
            if(conv[i] == 0){
                count++;
            }
            if (count == k){
                return true;
            }
        }
        return false;
    }
}

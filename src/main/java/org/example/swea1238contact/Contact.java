package org.example.swea1238contact;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Contact {
    public static int[][] graph;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        for (int tc = 1; tc<=10; tc++){
            st = new StringTokenizer(br.readLine());
            int dataLength = Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken());
            graph = new int[dataLength][dataLength];
            for (int i = 0; i<dataLength; i++){
                st = new StringTokenizer(br.readLine());

            }
        }
    }
}

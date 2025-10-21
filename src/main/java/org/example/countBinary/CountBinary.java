package org.example.countBinary;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CountBinary {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int t = 1; t<=T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(br.readLine());
            int M = Integer.parseInt(br.readLine());

            int mask = (1<<N) -1;
            if((M&mask) == mask){
                System.out.println("ON");
            } else{
                System.out.println("OFF");
            }
        }
    }
}

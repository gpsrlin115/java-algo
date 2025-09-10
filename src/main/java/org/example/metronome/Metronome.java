package org.example.metronome;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
public class Metronome{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        double a = (Double.parseDouble(br.readLine())/4);
        bw.write(String.valueOf(a));
        bw.flush();
        bw.close();
        br.close();
    }
}
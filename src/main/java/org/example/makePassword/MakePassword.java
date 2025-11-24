package org.example.makePassword;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class MakePassword {
    static BufferedWriter bw;
    static int L;
    static int C;
    static String vowel;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken()); // 암호길이
        C = Integer.parseInt(st.nextToken()); // 주어진 문자의 갯수
        vowel = "aeiou";
        String[] a = br.readLine().split(" ");
        boolean[] b = new boolean[C];
        Arrays.sort(a);
        recursive(a, b, 0, L);
        bw.flush();
        bw.close();
        br.close();
    }
    static void recursive(String[] a, boolean[] b, int sIndex, int pickCount) throws IOException{
        if(pickCount == 0){
            StringBuilder sb = new StringBuilder();
            int vow = 0, consonant =0;
            for(int i = 0; i<C; i++){
                if(b[i]){
                    sb.append(a[i]);
                    if(isVow(a[i].charAt(0))){
                        vow++;
                    }else{
                        consonant++;
                    }
                }
            }
            if(vow>=1 && consonant>=2){
                bw.write(sb.toString());
                bw.newLine();
            }
            return;
        }

        for (int i = sIndex; i<a.length; i++){
            b[i]=true;
            recursive(a, b, i+1, pickCount-1);
            b[i]=false;
        }
    }
    static boolean isVow(char c) {
        return vowel.indexOf(c) != -1;
    }
}

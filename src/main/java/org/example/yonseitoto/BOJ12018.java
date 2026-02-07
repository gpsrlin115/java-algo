package org.example.yonseitoto;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ12018 {
    static int p,l;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        List<Integer> minList = new ArrayList<>();
        int count=0;

        for(int i = 0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            p = Integer.parseInt(st.nextToken());//수강신청인원
            l = Integer.parseInt(st.nextToken());//인원제한
            if (p < l) {
                minList.add(1);
                br.readLine();
            }else {
                Integer[] cl = new Integer[p];
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j<p; j++){
                    cl[j] = Integer.parseInt(st.nextToken());
                }
                Arrays.sort(cl, Collections.reverseOrder());
                minList.add(cl[l-1]);

            }

        }
        Collections.sort(minList);
        for(int cost : minList){

            if(m>=cost){
                m-=cost;
                count++;
            } else {
                break;
            }
        }
        System.out.println(count);
    }
}

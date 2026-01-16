package A.LIS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n,k;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc<=T; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            arr = new int[n];
            for(int i = 0; i<n; i++){
                arr[i]=Integer.parseInt(st.nextToken());
            }
            int[] s = new int[arr.length-k+1];
            for(int i = 0 ; i<s.length; i++){
                s[i] = 0;
                for(int j = i; j<i+k; j++){
                    s[i] += arr[j];
                }
            }
            int[] maxS = new int[s.length];
            maxS[s.length-1] = s[s.length-1];
            for(int i = s.length-2 ; i>=0; i--){
                maxS[i] = Math.max(s[i], maxS[i+1]);
            }
            int ans = Integer.MIN_VALUE;
            for(int i =0; i+k<s.length; i++){
                ans = Math.max(ans, s[i]+maxS[i+k]);
            }
            System.out.println("#"+tc+" "+ans);
        }
    }
}

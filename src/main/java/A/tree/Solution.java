package A.tree;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * SWEA 14150. 나무 높이
 * @category 그리디
 */
public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int t =1; t<=T; t++){
            int n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            int maxHeight = Integer.MIN_VALUE;
            int[] trees = new int[n];
            for(int i = 0; i<n; i++){
                trees[i] = Integer.parseInt(st.nextToken());
                maxHeight = Math.max(maxHeight, trees[i]);
            }
            int even = 0, odd = 0;
            for(int h : trees){
                int diff = maxHeight-h;
                if(diff == 0) continue;
                even += diff/2;
                odd += diff%2;
            }
            if(even>odd){
                while(Math.abs(even-odd)>1){
                    even--;
                    odd+=2;
                }
            }
            int ans = 0;
            if(odd>even){
                ans = odd*2-1;
            } else if (even>odd){
                ans = even*2;
            } else{
                ans = odd+even;
            }
            System.out.println("#"+t+" "+ans);
        }
    }
}


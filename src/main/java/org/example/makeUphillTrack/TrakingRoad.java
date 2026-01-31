//package org.example.makeUphillTrack;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.StringTokenizer;
//
//public class TrakingRoad {
//    static int n,k,maxHeight,answer;
//    static int[][] arr;
//    static boolean[][] visited;
//    static int[] dr = {-1, 1, 0, 0};
//    static int[] dc = {0, 0, 1, -1};
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int T = Integer.parseInt(br.readLine());
//        for (int tc = 1; tc<=T; tc++){
//            StringTokenizer st = new StringTokenizer(br.readLine());
//            n = Integer.parseInt(st.nextToken());
//            k = Integer.parseInt(st.nextToken());
//            maxHeight=0;
//            answer = 0;
//            arr = new int[n][n][2];
//            for(int i = 0; i<n; i++){ //0-base index
//                st=new StringTokenizer(br.readLine());
//                for(int j = 0; j<n; j++){
//                    int h = Integer.parseInt(st.nextToken());
//                    arr[i][j][0]=h;
//                    arr[i][j][1]=h;
//                    maxHeight = Math.max(maxHeight, h);
//                }
//            }
//            for(int i = 0; i<n; i++){
//                for (int j = 0; j<n; j++){
//                    if(arr[i][j][0] == maxHeight){
//                        dfs(i,j,0,1);
//                    }
//                }
//            }
//            System.out.println("#"+tc+" "+answer);
//        }
//    }
//    static void dfs(int r, int c, int cut, int length){
//        answer = Math.max(answer, length);
//
//        int currentHeight = arr[r][c][cut];
//        for(int i =0; i<4; i++){
//            int nr = r+dr[i];
//            int nc = c+dc[i];
//
//            if(nr<0||nr>=arr.length||nc<0||nc>=arr.length)continue;
//
//            //그냥 이동
//            if(arr[nr][nc][cut]<currentHeight){
//                dfs(nr, nc, cut, length+1);
//            }
//            //깎고 이동
//            else if (cut==0) {
//                for(int j = 1; j<=k; j++){
//                    int newHeight= currentHeight-1;
//                    if(newHeight<currentHeight){
//                        int original = arr[nr][nc][1];
//                        arr[nr][nc][1] = newHeight;
//                        dfs(nr,nc,1, length+1);
//                        arr[nr][nc][1] = original;
//                    }
//                }
//            }
//        }
//    }
//}

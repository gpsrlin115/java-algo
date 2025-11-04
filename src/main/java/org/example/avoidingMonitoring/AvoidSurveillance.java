package org.example.avoidingMonitoring;
import java.io.*;
import java.util.*;

public class AvoidSurveillance {
    static int N;
    static char[][] board;
    static List<int[]> empties = new ArrayList<>();
    static List<int[]> teachers = new ArrayList<>();
    static int[] dr = {-1, 1, 0, 0}; // 상하좌우
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine().trim());
        board = new char[N][N];

        for (int r = 0; r < N; r++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int c = 0; c < N; c++) {
                board[r][c] = st.nextToken().charAt(0);
                if (board[r][c] == 'X') empties.add(new int[]{r, c});
                if (board[r][c] == 'T') teachers.add(new int[]{r, c});
            }
        }

        boolean possible = pickObstaclesAndTest();
        System.out.println(possible ? "YES" : "NO");
    }

    static boolean pickObstaclesAndTest() {
        // 1) empties에서 3개 조합 뽑기 (백트래킹 or 3중 for)
        for(int i =0; i<empties.size(); i++){
            for(int j=i+1; j<empties.size(); j++){
                for(int k=j+1; k<empties.size(); k++){
                    int[] e1 = empties.get(i);
                    int[] e2 = empties.get(j);
                    int[] e3 = empties.get(k);
                    // 고른 3칸에 'O' 배치
                    board[e1[0]][e1[1]] = 'O';
                    board[e2[0]][e2[1]] = 'O';
                    board[e3[0]][e3[1]] = 'O';
                    //checkSafe() 호출
                    if (checkSafe()) return true; // 감시 피하기 성공

                    // 원상복구
                    board[e1[0]][e1[1]] = 'X';
                    board[e2[0]][e2[1]] = 'X';
                    board[e3[0]][e3[1]] = 'X';
                }
            }
        }
        return false;
    }

    static boolean checkSafe() {
        // 모든 선생에 대해 4방향으로 스캔
        boolean b;
        for(int[] t : teachers){
            int r = t[0];
            int c = t[1];
            for(int d = 0; d<4; d++){
                boolean bc =watchOneDir(r, c, d);
                if (bc){
                    return false; // 실패
                }
            }
        }
        return true; //성공
    }

    static boolean watchOneDir(int sr, int sc, int d) {
        // (sr, sc)에서 방향 d로 한 칸씩 전진
        int nr = sr + dr[d];
        int nc = sc + dc[d];
        // 'O'를 만나면 멈춤, 'S'를 만나면 true(잡힘)
        while(nr>=0&&nr<N&&nc>=0&&nc<N){
            if(board[nr][nc]=='O')return false;
            if(board[nr][nc]=='S')return true;
            nr+=dr[d];
            nc+=dc[d];
        }
        // 범위 밖이면 false(그 방향 OK)
        return false; //끝까지 갔을때 학생 없음
    }
}

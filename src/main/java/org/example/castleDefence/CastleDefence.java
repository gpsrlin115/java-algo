package org.example.castleDefence;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOError;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class CastleDefence {
    static int N,M,D,Ans = 0; //n : 궁수자리 
    static class Enemy {
        int r,c;
        Enemy(int r, int c){
            this.r = r;
            this.c = c;
        }
        @Override
        public String toString() {
            return "Enemy [r=" + r + ", c=" + c + "]";
        }

    }
    static ArrayList<Enemy> enemies = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // 궁수 N+1 번째 row에 3명 배치
        // 적은 한칸씩 아래로 이동
        // 궁수는 3명, 공격거리 D이하인 적 중에서
        // 가장 가까운 적이 공격, 거리가 같다면 왼쪽부터 (<< 정렬, Comparable?)
        // 모든 궁수는 "동시에" 공격한다 (2차원 루프로 돌 수 없다..)
        // 같은 적이 여러궁수에게 공격당할 수 있다.(한번의 공격으로 안죽을 수 있겠네...)
        // 그 턴이 끝날때 까지는 궁수가 제거되면 안됨.
        // 모든 적이 격자판에서 제거되거나, 성에 도달했을 때 게임에서 제외
        // 모든 적이 격자판에서 제외되면 게임 끝
        // 제거한 적의 수가 최대가 되도록 궁수의 위치를 선정
        // 맨하탄 -> 2차원 배열 아님. 그래프의 사방탐색으로 거리공식 못구함.
        // 적의 위치를 저장할 배열 필요
        // 1차원배열로 할 수 있는데 배열은 제거가 힘듬...
        // 2차원 배열로 할 수 있는데, 적의 위치를 찾는게 힘듬...
        // List로 구현
        // 1. 궁수의 위치 조합으로 선정 (mC3 시뮬레이션)
        // 2. 적 이동
        // 3. 궁수 공격
        // 4. 제거한 적의 수 카운트
        // 5. 적이 모두 제거되었거나, 성에 도달했을 때 게임 종료
        // 6. 1~5 반복
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        for(int i=0; i<N; i++){
            String line = br.readLine();
            for(int j=0; j<M; j++){
                if(line.charAt(j) == '1'){
                    enemies.add(new Enemy(i,j));
                }
            }
        }

        // 궁수의 위치 조합으로 선정
        comb(0,0,new int[3]);
        bw.write(String.valueOf(Ans));
        bw.flush();
        bw.close();
        br.close();

    }

    static void comb(int idx, int cnt, int[] sel){
        if(cnt == sel.length){
            // 궁수의 위치가 정해졌다면 시뮬레이션 시작
            //simulate(archers);
            //10번 궁수자리수마다 시뮬레이션을 돌려야 한다.
            
            //코인넣고 한판 돌리기
            List<Enemy> ones = new ArrayList<>(); // 적의 위치를 복사
            // 얕은복사 주의
            for(Enemy e : enemies){ // ones.add(enemys.get(i)) << 이러면 안됨 큰일남 복사가 아니라 주소 복사... 얕은복사 
                ones.add(new Enemy(e.r, e.c));
            }
            //궁수가 범위안에 있는 적을 사살한다.(enemy를 복사하던지, 백트래킹을 하던지)
            while(ones.size() > 0){ // 적이 남아있는 동안
                List<Enemy> toBeRemoved = new ArrayList<>(); // 이번 턴에 제거할 적들
                for(int archer : sel){ // 궁수마다
                    Enemy target = null; // 이번 턴에 공격할 적
                    int minDist = Integer.MAX_VALUE;
                    for(Enemy enemy : ones){ // 남아있는 적들 중에서
                        int dist = Math.abs(enemy.r - N) + Math.abs(enemy.c - archer); // 궁수와 적의 거리
                        if(dist <= D){ // 사정거리 안에 있다면
                            if(dist < minDist){ // 가장 가까운 적을 찾는다
                                minDist = dist;
                                target = enemy;
                            } else if(dist == minDist){ // 거리가 같다면 왼쪽에 있는 적을 찾는다
                                if(enemy.c < target.c){
                                    target = enemy;
                                }
                            }
                        }
                    }
                    if(target != null && !toBeRemoved.contains(target)){ // 사정거리 안에 있는 적이 있다면, 그리고 이미 제거할 목록에 없다면 << 생각하기 어려운 파트
                        toBeRemoved.add(target); // 제거할 목록에 추가
                    }
                }
                // 제거할 적들을 제거
                for(Enemy e : toBeRemoved){
                    ones.remove(e);
                    Ans++;
                }
                // 적은 1보 전진한다
                List<Enemy> survived = new ArrayList<>();
                for(Enemy e : ones){
                    if(e.r + 1 < N){ // 성에 도달하지 않았다면
                        survived.add(new Enemy(e.r + 1, e.c));
                    }
                }

                //죽인 적의 수 중 많은 값을 저장
                ones = survived;

            }


            return;
        }
        if(idx == M) return; // 더 뽑을 자리가 없어용.
        sel[cnt] = idx;
        comb(idx+1, cnt+1, sel);
        comb(idx+1, cnt, sel);
    }

    // static void simulate(int[] archers){
    //     // 적의 위치를 복사
    //     List<Enemy> copy = new ArrayList<>();
    //     for(Enemy e : enemies){
    //         copy.add(new Enemy(e.r, e.c));
    //     }
    //     int killed = 0; // 제거한 적의 수
    //     // 적이 모두 제거되었거나, 성에 도달했을 때 게임 종료
    //     while(!copy.isEmpty()){
    //         // 1. 궁수 공격
    //         List<Enemy> toBeRemoved = new ArrayList<>();
    //         for(int archer : archers){
    //             Enemy target = null;
    //             int minDist = Integer.MAX_VALUE;
    //             for(Enemy enemy : copy){
    //                 int dist = Math.abs(enemy.r - N) + Math.abs(enemy.c - archer);
    //                 if(dist <= D){
    //                     if(dist < minDist){
    //                         minDist = dist;
    //                         target = enemy;
    //                     } else if(dist == minDist){
    //                         if(enemy.c < target.c){
    //                             target = enemy;
    //                         }
    //                     }
    //                 }
    //             }
    //             if(target != null && !toBeRemoved.contains(target)){
    //                 toBeRemoved.add(target);
    //             }
    //         }
    //         // 제거할 적들을 제거
    //         for(Enemy e : toBeRemoved){
    //             copy.remove(e);
    //             killed++;
    //         }
    //         // 2. 적은 1보 전진한다
    //         List<Enemy> survived = new ArrayList<>();
    //         for(Enemy e : copy){
    //             if(e.r + 1 < N){ // 성에 도달하지 않았다면
    //                 survived.add(new Enemy(e.r + 1, e.c));
    //             }
    //         }
    //         copy = survived;
    //     }
    //     Ans = Math.max(Ans, killed);
    // }

}


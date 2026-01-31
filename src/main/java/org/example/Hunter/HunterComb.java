package org.example.Hunter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class HunterComb {
    static class Node{
        int name;
        int r;
        int c;

        Node(int r, int c, int name){
            this.r =r;
            this.c =c;
            this.name= name;
        }
    }
    static List<Node> nodes;
    static int result = 0x3f3f3f3f;
    static int T, N;

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for(int tc =1; tc<=T; tc++){
            N = Integer.parseInt(br.readLine());
            int[][] map = new int[N][N]; //맵
            int monsterNum = 0; // 몬스터의 번호 지정
            nodes = new ArrayList<>(); // 노드들 모음 리스트
            List<Integer> monsterList = new ArrayList<>(); // 몬스터들 리스트 (번호들)
            for(int r = 0; r<N; r++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int c = 0; c<N; c++){
                    map[r][c] = Integer.parseInt(st.nextToken());
                    if(map[r][c]!=0){
                        Node node = new Node(r,c, map[r][c]); //노드 좌표랑 무슨 번호인지.
                        nodes.add(node);// 노드 리스트들에 넣고
                        if(map[r][c]>0){//0보다 크면
                            monsterList.add(map[r][c]); //양수니까 몬스터를 넣고
                            monsterNum = Math.max(map[r][c], monsterNum); // 큰숫자가 곧 몬스터 수 (마지막 몬스터)
                        }
                    }
                }
            }
            comb(monsterList, new int[monsterNum*2], 0, new ArrayList<Integer>()); //몹리스트, 선택배열, 깊이, 커스터머 저장할 리스트
            System.out.println("#"+tc+" "+result);
            result = 0x3f3f3f3f;
            nodes = new ArrayList<>();
        }
    }
    static void comb(List<Integer> monsterList, int[] sel, int depth, List<Integer> customer) { //sel-> 방문배열
        if (sel.length == depth) { // 단계가 끝나면
            int dist = 0; //거리
            int[] cur = new int[]{0, 0}; //현재 위치
            for (int i = 0; i < sel.length; i++) { //선택 배열의 길이만큼
                int[] target = new int[2]; // r、c좌표 저장
                for (Node node : nodes) { // 노드 뽑아서
                    if (node.name == sel[i]) { //선택한거 node에 저장
                        target[0] = node.r;
                        target[1] = node.c;
                        break;
                    }
                }
                dist += Math.abs(cur[0] - target[0]) + Math.abs(cur[1] - target[1]); // 맨하탄
                cur[0] = target[0];
                cur[1] = target[1];
            }
            result = Math.min(result, dist);
            return;
        }
        if(depth == 0){ //일단 먼저 잡을 괴물부터
            for (int i =0; i<monsterList.size(); i++){
                int target = monsterList.get(i);//몬스터 리스트에 있는 맨 처음 몹 끌어와서 target잡기
                sel[depth] = target; // 이번 단계에서 이걸 노릴꺼임
                customer.add(target*-1); // 그 몹과 손님은 양수-음수 대응관계

                int temp = monsterList.get(i); //원상 복구를 위한 temp
                monsterList.remove(i);// 고로시
                comb(monsterList, sel, depth+1, customer); // 재귀
                monsterList.add(i, temp); // 원상
                customer.remove(customer.size()-1); //복귀
            }
        } else{
            if (monsterList.size() > 0 || customer.size()>0 ) {
                //monster 또 잡으러 가기
                for(int i = 0; i< monsterList.size(); i++){
                    int target = monsterList.get(i);
                    sel[depth] = target; // 이번 깊이에 이 몬스터를 방문한다고 기록.
                    customer.add(target*-1); // 그 몬스터를 잡았으니까 그 몹에 대응 하는 고객을 방문가능 목록에 추가

                    int temp = monsterList.get(i);
                    monsterList.remove(i);// 현재 선택한 몬스터를 monsterList에서 제거
                    comb(monsterList, sel, depth+1, customer); //재귀
                    monsterList.add(i, temp); // 다시 원상
                    customer.remove(customer.size()-1); //복귀
                }
                for(int i = 0; i<customer.size(); i++){ //고객에게 방문
                    int target = customer.get(i); //customer 배열에서 customer 이름을 빼와서 이번 단계에
                    sel[depth] = target; //선택 배열에 target 이름 넣기

                    int temp = customer.get(i); //원상복귀를 위한 temp
                    customer.remove(i);
                    comb(monsterList, sel, depth+1, customer);
                    customer.add(i, temp);
                }
            }
        }
    }
}

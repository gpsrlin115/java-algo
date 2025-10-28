package org.example.kaka;
import java.util.*;

public class secretmm {
    static class Word {
        int id;
        int start, end;       // inclusive
        String text;
        int required;         // 스포 영역(숨겨진) 글자 수
        int revealed;         // 현재까지 공개된 스포 글자 수
        boolean completed;    // 이미 "완전 공개" 된 적 있는지 (중복 처리 방지)
        Word(int id, int s, int e, String t) {
            this.id = id;
            this.start = s;
            this.end = e;
            this.text = t;
        }
    }

    public int solution(String message, int[][] spoiler_ranges) {
        final int n = message.length();
        char[] arr = message.toCharArray();

        // 1) 단어 파싱: words, index->wordId
        List<Word> words = new ArrayList<>();
        int[] indexToWord = new int[n];
        Arrays.fill(indexToWord, -1);

        int i = 0, wid = 0;
        while (i < n) {
            if (arr[i] == ' ') { i++; continue; }
            int s = i;
            while (i < n && arr[i] != ' ') i++;
            int e = i - 1;
            String text = message.substring(s, e + 1);
            Word w = new Word(wid, s, e, text);
            words.add(w);
            for (int k = s; k <= e; k++) indexToWord[k] = wid;
            wid++;
        }

        // 2) 스포 인덱스 표시
        boolean[] isSpoIdx = new boolean[n];
        for (int[] rg : spoiler_ranges) {
            int L = rg[0], R = rg[1];
            for (int k = L; k <= R; k++) {
                isSpoIdx[k] = true;
            }
        }

        // 3) 각 단어의 required(스포 글자 수) 계산
        for (Word w : words) {
            int cnt = 0;
            for (int k = w.start; k <= w.end; k++) {
                if (isSpoIdx[k]) cnt++;
            }
            w.required = cnt;
        }

        // 4) 조건(2): 단어 텍스트가 비스포 구간에서 완전 등장한 적 있는지
        //    (그 단어의 어떤 출현이든 required==0 이면 true)
        Map<String, Boolean> hasNonSpoOccur = new HashMap<>();
        for (Word w : words) {
            if (!hasNonSpoOccur.containsKey(w.text)) hasNonSpoOccur.put(w.text, false);
            if (w.required == 0) {
                hasNonSpoOccur.put(w.text, true);
            }
        }

        // 5) 공개(클릭) 시뮬레이션: 왼->오 순서로 구간을 "연다"
        int answer = 0;
        Set<String> countedImportant = new HashSet<>(); // 조건(3): 이미 중요한 단어로 센 텍스트
        boolean[] alreadyOpened = new boolean[n];       // 열린(공개된) 스포 인덱스 표시

        for (int[] rg : spoiler_ranges) {
            int L = rg[0], R = rg[1];

            // 이 구간으로 인해 영향을 받은 단어들 모으기
            // (동시에 완전 공개된 단어를 왼→오 순으로 처리하기 위함)
            Set<Integer> touched = new HashSet<>();

            for (int k = L; k <= R; k++) {
                if (!alreadyOpened[k]) {
                    alreadyOpened[k] = true;
                    int wId = indexToWord[k];
                    if (wId != -1 && isSpoIdx[k]) {
                        Word w = words.get(wId);
                        w.revealed += 1;   // 스포 글자 중 이제 공개된 1글자
                        touched.add(wId);
                    }
                }
            }

            // 이번 클릭으로 "처음으로 완전 공개"가 된 단어들만 모아 왼→오 순 처리
            List<Word> newlyCompleted = new ArrayList<>();
            for (int wId : touched) {
                Word w = words.get(wId);
                if (!w.completed && w.revealed == w.required) {
                    w.completed = true;
                    newlyCompleted.add(w);
                }
            }
            newlyCompleted.sort(Comparator.comparingInt(a -> a.start)); // 왼쪽부터

            // 왼→오 순으로 중요한 단어인지 판정
            for (Word w : newlyCompleted) {
                // (1) 스포일러 단어여야 함
                if (w.required == 0) continue;

                // (2) 이 단어 텍스트가 비스포 구간 출현이 없어야 함
                if (hasNonSpoOccur.getOrDefault(w.text, false)) continue;

                // (3) 이전에 같은 텍스트를 중요한 단어로 센 적 없어야 함
                if (countedImportant.contains(w.text)) continue;

                // 모두 만족 → 카운트
                answer++;
                countedImportant.add(w.text);
            }
        }

        return answer;
    }

    // 간단 검증용 main
    public static void main(String[] args) {
        secretmm s = new secretmm();

        String m1 = "here is muzi hgere is a secret message";
        int[][] r1 = {{0,3},{23,28}};
        System.out.println(s.solution(m1, r1)); // 기대: 1

        String m2 = "my phone number is 01012345678 and may i have your phone number";
        int[][] r2 = {{5,5},{25,28},{34,40},{53,59}};
        System.out.println(s.solution(m2, r2)); // 기대: 4
    }
}

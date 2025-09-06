package org.example.imgoingtodieifIdonteateggplant;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;

public class ImgoingtodieifIdonteatseggplants {
    static class Edge implements Comparable<Edge> {
        int u, v, t;

        public Edge(int u, int v, int t) {
            this.u = u;
            this.v = v;
            this.t = t;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.t, o.t);
        }
    }

    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Edge[] edges = new Edge[M];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            edges[i] = new Edge(u, v, t);
        }

        Arrays.sort(edges); // 이걸 빼면 무작위 스패닝 트리가 나온다... 이걸 정렬해서 제일 가중치가 낮은 스패닝트리를 구성.
        //그리디...

        parent = new int[N + 1];
        Arrays.fill(parent, -1);

        int day = 1;
        int usedEdges = 0;

        for (Edge e : edges) {
            if (e.t != day) break;  // 날이 연속되지 않음 -> 실패
            if (union(e.u, e.v)) {
                usedEdges++;
                day++;
                if (usedEdges == N - 1) break; // 모든 학원 연결됨
            } else {
                // 사이클
                break;
            }
        }

        bw.write(String.valueOf(day));
        bw.newLine();
        bw.flush();
        bw.close();
        br.close();
    }

    static boolean union(int u, int v) {
        u = find(u);
        v = find(v);
        if (u == v) return false;
        if (parent[u] > parent[v]) {
            int tmp = u; u = v; v = tmp;
        }
        parent[u] += parent[v];
        parent[v] = u;
        return true;
    }

    static int find(int x) {
        if (parent[x] < 0) return x;
        return parent[x] = find(parent[x]);
    }
}

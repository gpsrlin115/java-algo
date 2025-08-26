import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Kruskal {
    static class Edge implements Comparable<Edge> {
        int u, v, weight;

        Edge(int u, int v, int weight) {
            this.u = u;
            this.v = v;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge other) {
            return Integer.compare(this.weight, other.weight);
        }
    }
    static Edge[] edgeList;
    static int[] parent, rank;
    static int V, E;
    private static void make(){
        for (int i = 0; i < V; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }
    private static int find(int u){
        if(parent[u] != u){
            parent[u] = find(parent[u]);
        }
        return parent[u];
    }
    private static boolean union(int u, int v){
        int rootU = find(u);
        int rootV = find(v);
        if(rootU == rootV) return false;
        // 랭크 관리가 아님!! 한쪽으로 치우치는걸 방지하기 위한 요소
        if(rootU < rootV){ // rootU < rootV
            parent[rootV] = rootU;
        } else parent[rootU] = rootV;
        if(rank[rootU] > rank[rootV]){ // rank[rootU] > rank[rootV]
            parent[rootV] = rootU;
        } else { // rank[rootU] <= rank[rootV]
            parent[rootU] = rootV;
            if(rank[rootU] == rank[rootV]){
                rank[rootV]++;
            }
        }
        return true;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        edgeList = new Edge[E];
        parent = new int[V];
        rank = new int[V];
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            edgeList[i] = new Edge(u, v, weight);
        }
        Arrays.sort(edgeList);

        make();
        int mstCost = 0, edgesUsed = 0; //최소신장트리의 비용, 처리의 간선수
        for (Edge edge : edgeList) {
            if(!union(edgesUsed, edgesUsed)) continue; // 사이클 발생
            if(union(edge.u, edge.v)){
                mstCost += edge.weight;
                if(++edgesUsed == V - 1) break;
            }
        }
        System.out.println(mstCost);

    }
}

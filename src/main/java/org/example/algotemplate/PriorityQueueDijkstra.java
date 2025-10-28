package org.example.algotemplate;

public class PriorityQueueDijkstra {
    static class Node implements Comparable<Node>{
        int vertex, weight;
        public Node(int vertex, int weight){
            this.vertex = vertex;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o){
            return this.weight - o.weight;
        }
    }

    static final int INF = Integer.MAX_VALUE;
}

package com.algorithm.codingTest.kit.graph.ex01;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Dijkstra {

    public static void main(String[] args) {
        Graph g = new Graph(6); // 노드 수 만큼 그래프 생성 // 시작, 끝, 간선 가중치 입력
        g.addWeight(0, 1, 7);
        g.addWeight(0, 2, 9);
        g.addWeight(0, 5, 14);
        g.addWeight(1, 2, 10);
        g.addWeight(1, 3, 15);
        g.addWeight(2, 3, 11);
        g.addWeight(2, 5, 2);
        g.addWeight(3, 4, 6);
        g.addWeight(4, 5, 9);

        g.dijkstra(0);
    }
}

class Graph {
    private int n;
    private int[][] weights;

    public Graph(int n) {
        this.n = n;
        this.weights = new int[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(this.weights[i], Integer.MAX_VALUE);
        }
    }

    public void addWeight(int i, int j, int w) {
        this.weights[i][j] = w;
        this.weights[j][i] = w;
    }

    public void dijkstra(int v) {
        boolean[] visited = new boolean[this.n];
        int[] distance = new int[this.n];
        Arrays.fill(distance, Integer.MAX_VALUE);

        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(v));
        distance[v] = 0;

        while (!queue.isEmpty()) {
            Node qNode = queue.poll();
            int node = qNode.getNode();
            visited[node] = true;

            for (int i = 0; i < this.n; i++) {
                if(!visited[i] && this.weights[node][i] != Integer.MAX_VALUE) {
                    if(distance[node] + this.weights[node][i] < distance[i]) {
                        distance[i] = distance[node] + this.weights[node][i];
                        queue.offer(new Node(i));
                    }
                }
            }
        }
        System.out.println(Arrays.toString(distance));
    }
}

class Node {
    private int node;

    public Node(int node) {
        this.node = node;
    }

    public int getNode() {
        return node;
    }
}

package com.algorithm.codingTest.kit.graph.ex02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class FloydWarshall {

    // 플로이드와 비교해보기 위해 만듬
    public static int[] dijkstra(int v, int[][] dist) {
        int[] result = new int[dist.length];
        Arrays.fill(result, Integer.MAX_VALUE);

        boolean[] visited = new boolean[dist.length];

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(v);
        result[v] = 0;

        while (!queue.isEmpty()) {
            Integer node = queue.poll();
            visited[node] = true;

            for (int i = 0; i < dist.length; i++) {
                if(!visited[i] && dist[node][i] != Integer.MAX_VALUE) {
                    if(result[node] + dist[node][i] < result[i]) {
                        result[i] = result[node] + dist[node][i];
                        queue.offer(i);
                    }
                }
            }
        }

        return result;
    }

    public static void main(String[] args) throws IOException {
        int N = 5;
        int[][] vertex = {{0, 1, 5}, {0, 2, 7}, {0, 3, 2}, {0, 4, 1}, {1, 2, 3}, {1, 3, 6}, {2, 3, 10}, {3, 4, 4}};
        int[][] dist = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                // 자기 자신으로 가는 길은 최소 비용이 0이다.
                if (i == j) {
                    dist[i][j] = 0;
                    continue;
                }
                // 자기 자신으로 가는 경우를 제외하고는 매우 큰 값(N개의 노드를 모두 거쳐서 가더라도 더 큰 값).
                dist[i][j] = 100_000_000;
            }
        }

        for (int i = 0; i < vertex.length; i++) {
            dist[vertex[i][0]][vertex[i][1]] = vertex[i][2];
            dist[vertex[i][1]][vertex[i][0]] = vertex[i][2];
        }

        for (int i = 0; i < dist.length; i++) {
            System.out.println(Arrays.toString(dist[i]));
        }
        System.out.println();

        // 플로이드 워셜 알고리즘
        // 노드를 1개부터 N개까지 거쳐가는 경우를 모두 고려한다.
        for (int k = 0; k < N; k++) {
            // 노드 i에서 j로 가는 경우.
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    // k번째 노드를 거쳐가는 비용이 기존 비용보다 더 작은 경우 갱신
                    // 또는 연결이 안되어있던 경우(INF) 연결 비용 갱신.
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }

        // 출력
        for (int i = 0; i < N; i++) {
            System.out.println(Arrays.toString(dist[i]));
        }

        // 다익스타라 사용
        /*for (int i = 0; i < N; i++) {
            int[] res = dijkstra(i, dist);
            System.out.println(Arrays.toString(res));
        }
        System.out.println();*/
    }
}

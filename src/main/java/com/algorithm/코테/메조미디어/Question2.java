package com.algorithm.코테.메조미디어;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.IntStream;

/**
 * 최근 전기자동차를 구입한 진구는 여러 대의 충전기가 있는 전기차 충전소에 도착했습니다. 그런데, 아직 충전소가 영업을 시작하기 전인데도 배터리를 충전하려고 충전소에 도착해 있는 차량들이 꽤 있었습니다.
 * 아직은 영업시간 전이라 모든 충전기가 비어 있으며, 전기차들은 충전기를 이용하기 위해 충전소에 도착한 수서대로 일렬로 줄을 이루어 기다리고 있습니다.
 *
 * 이 충전소에서는, 이용할 수 있는(먼저 충전을 시작한 다른 차량이 점유하고 있지 않은) 충전기가 생기면 먼저 도착한 차량부터 배터리를 충전하도록 규칙을 정해 두고 있습니다. 동시에 두 개 이상의 충전기가 비어 있게 되면 보다 낮은 번호의 충전기부터 이용합니다.
 * 진구는 자신의 차량이 언제 어느 충전기에서 충전을 마치게 될지를 예상해 보고 싶었습니다.
 *
 * 각 차량의 배터리를 충전하는 데 걸리는 시간은 배터리 잔량에 따라 다르지만, 다행히 충전을 시작하기 이전에 이미 소요 시간을 예측할 수 있는 장치가 있었습니다. 진구는 자신보다 먼저 도착하여 순서를 기다리는 다른 차량들의 배터리 충전 시간을 모두 조사했습니다.
 *
 * 예를 들어, 충전기가 3대 있는 충전소에 차량 8대가 도착해있고, 각 차량이 충전을 마치는 데까지 걸리는 시간이 옆에 있는 차량부터 순서대로[5, 7, 2, 3, 3, 6, 4, 3]인 상황을 생각해 봅시다. 편의상 각 차량에 A, B, C, ..., H 의 기호가 매겨져 있다고 가정하며, 마지막 차량인 H가 진구의 것입니다.
 * 아직 충전소가 영업을 시작하기 전, 즉 시간이 0일때는 아래 그림과 같이 차량 8대가 대기열에 늘어서 있습니다.
 *
 */
public class Question2 {
    /*public int[] solution(int N, int K, int[] charges) {
        Queue<Integer> queue = new LinkedList<>();
        for (int charge : charges) {
            queue.add(charge);
        }

        int[] stations = new int[N];
        stations[0] = queue.poll();

        int stationIndex = 0;
        while (!queue.isEmpty()) {
            Integer time = queue.poll();

            stationIndex = 0;
            for (int i = 1; i < N; i++) {
                if (stations[i] < stations[stationIndex]) {
                    stationIndex = i;
                }
            }
            stations[stationIndex] += time;
        }

        return new int[]{stationIndex + 1, stations[stationIndex]};
    }*/

    public int[] solution(int N, int K, int[] charges) {
        Queue<Integer> queue = new LinkedList<>();
        for (int charge : charges) {
            queue.add(charge);
        }

        int[] stations = new int[N];
        stations[0] = queue.poll();

        int stationIndex = 0;
        while (!queue.isEmpty()) {
            Integer time = queue.poll();

            stationIndex = IntStream.range(0, N)
                    .boxed()
                    .min(Comparator.comparingInt(i -> stations[i]))
                    .orElse(0);

            stations[stationIndex] += time;
        }

        return new int[]{stationIndex + 1, stations[stationIndex]};
    }

    public static void main(String[] args) {
//        int N = 3;
//        int K = 8;
//        int[] charges = {5, 7, 2, 3, 3, 6, 4, 3}; // 1, 11

        int N = 4;
        int K = 10;
        int[] charges = {1, 6, 7, 2, 1, 10, 3, 5, 2, 3}; // 3, 10

        Question2 question1 = new Question2();
        int[] answer = question1.solution(N, K, charges);
        System.out.println(Arrays.toString(answer));
    }
}

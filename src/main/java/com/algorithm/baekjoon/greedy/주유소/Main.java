package com.algorithm.baekjoon.greedy.주유소;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[] distance = new int[N-1];
        int[] price = new int[N];

        for (int i = 0; i < distance.length; i++) {
            distance[i] = in.nextInt();
        }
        for (int i = 0; i < price.length; i++) {
            price[i] = in.nextInt();
        }

        long sum = 0;
        long minCost = price[0];	// 이전 까지의 과정 중 주유 최소 비용

        for(int i = 0; i < N - 1; i++) {

            /*
             *  현재 주유소가 이전 주유소의 기름값보다 쌀 경우
             *  minCost를 갱신해준다.
             */
            if(price[i] < minCost) {
                minCost = price[i];
            }

            sum += (minCost * distance[i]);	// 총 비용 누적 합
        }

        System.out.println(sum);
    }
}

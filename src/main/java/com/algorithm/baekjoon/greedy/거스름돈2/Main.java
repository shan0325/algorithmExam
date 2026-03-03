package com.algorithm.baekjoon.greedy.거스름돈2;

import java.util.Scanner;

/**
 * 춘향이는 편의점 카운터에서 일한다.
 *
 * 손님이 2원짜리와 5원짜리로만 거스름돈을 달라고 한다. 2원짜리 동전과 5원짜리 동전은 무한정 많이 가지고 있다. 동전의 개수가 최소가 되도록 거슬러 주어야 한다. 거스름돈이 n인 경우, 최소 동전의 개수가 몇 개인지 알려주는 프로그램을 작성하시오.
 *
 * 예를 들어, 거스름돈이 15원이면 5원짜리 3개를, 거스름돈이 14원이면 5원짜리 2개와 2원짜리 2개로 총 4개를, 거스름돈이 13원이면 5원짜리 1개와 2원짜리 4개로 총 5개를 주어야 동전의 개수가 최소가 된다.
 *
 * 입력 13 출력 5
 * 입력 14 출력 4
 */
public class Main {
    /*public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int money = in.nextInt();

        int fiveCount = money / 5;
        while (fiveCount >= 0) {
            int rest = money - (5 * fiveCount);
            if (rest % 2 == 0) {
                int twoCount = rest / 2;
                System.out.println(fiveCount + twoCount);
                return;
            }
            fiveCount--;
        }

        System.out.println(-1);
    }*/

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int money = in.nextInt();

        int count = 0;
        while (true) {
            if (money % 5 == 0) {
                count += money / 5;
                System.out.println(count);
                return;
            } else {
                money -= 2;
                count++;
            }
            if (money < 0) {
                System.out.println(-1);
                return;
            }
        }
    }
}

package com.algorithm.baekjoon.greedy.팰린드롬만들기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


/**
 * 임한수와 임문빈은 서로 사랑하는 사이이다.
 * 임한수는 세상에서 팰린드롬인 문자열을 너무 좋아하기 때문에, 둘의 백일을 기념해서 임문빈은 팰린드롬을 선물해주려고 한다.
 * 임문빈은 임한수의 영어 이름으로 팰린드롬을 만들려고 하는데, 임한수의 영어 이름의 알파벳 순서를 적절히 바꿔서 팰린드롬을 만들려고 한다.
 * 임문빈을 도와 임한수의 영어 이름을 팰린드롬으로 바꾸는 프로그램을 작성하시오.
 *
 * 입력 AABB 출력 ABBA
 * 입력 AAABB 출력 ABABA
 * 입력 ABACABA 출력 AABCBAA
 * 입력 ABCD 출력 I'm Sorry Hansoo
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();

        int[] arr = new int[26];
        for (int i = 0; i < line.length(); i++) {
            int index = line.charAt(i) - 'A';
            arr[index]++;
        }

        // 홀수가 1개 이상인 경우 "I'm Sorry Hansoo" 출력
        long oddCount = Arrays.stream(arr).filter(c -> c % 2 != 0).count();
        if (oddCount > 1) {
            System.out.println("I'm Sorry Hansoo");
            return;
        }

        // 모든 알파벳을 (알파벳 개수)/2개 만큼 문자열에 담는다. (front)
        StringBuilder frontSb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i] / 2; j++) {
                frontSb.append((char) (i + 'A'));
            }
        }
        String front = frontSb.toString();

        // 홀수 개를 가지는 문자를 하나씩 담는다. (mid)
        StringBuilder middle = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 != 0) {
                middle.append((char) (i + 'A'));
            }
        }

        // front reverse하여 끝 부분의 문자열을 구한다.
        String end = frontSb.reverse().toString();

        System.out.println(front + middle + end);
    }
}

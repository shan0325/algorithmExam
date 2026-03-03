package com.algorithm.baekjoon.greedy.배;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer> crains = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            crains.add(Integer.parseInt(st.nextToken()));
        }
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        List<Integer> boxes = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            boxes.add(Integer.parseInt(st.nextToken()));
        }
        crains.sort(Collections.reverseOrder());
        boxes.sort(Collections.reverseOrder());

        if (boxes.get(0) > crains.get(0)) {
            System.out.println(-1);
            return;
        }

        int minute = 0;
        while (!boxes.isEmpty()) {
            int boxIndex = 0;
            int crainIndex = 0;
            while (crainIndex < N) {
                if (boxIndex == boxes.size()) break;
                if (boxes.get(boxIndex) <= crains.get(crainIndex)) {
                    boxes.remove(boxIndex);
                    crainIndex++;
                } else {
                    boxIndex++;
                }
            }
            minute++;
        }
        System.out.println(minute);
    }
}

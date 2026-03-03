package com.algorithm.baekjoon.greedy.보석도둑;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main2 {
    public static void main(String[] args) throws IOException {
        //입력값 처리하는 BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //결과값 출력하는 BufferedWriter
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] bag = new int[K];
        int[][] jewels = new int[N][2];
        //보석 입력값 저장
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            jewels[i][0] = Integer.parseInt(st.nextToken());
            jewels[i][1] = Integer.parseInt(st.nextToken());
        }
        //가방 입력값 저장
        for(int i=0;i<K;i++){
            int C = Integer.parseInt(br.readLine());
            bag[i] = C;
        }
        Arrays.sort(bag);	//가방 오름차순 정렬
        Arrays.sort(jewels, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o2[1] - o1[1];
            }
            return o1[0] - o2[0];
        });	//보석 정렬
        //PriorityQueue 생성 및 내림차순 정렬로 설정
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        //가방 무게가 낮은 것부터 탐색.
        long answer = 0;
        int index = 0;
        for(int i = 0; i < K; i++){
            while(index < N){
                if(bag[i] < jewels[index][0])	//다음 보석부터 가방의 무게보다 클 때
                    break;
                pq.add(jewels[index][1]);	//가방에 보석을 넣을 수 있을 때
                index++;
            }
            //넣을 수 있는 보석이 있을 때 가장 가치가 높은 것 넣기
            if(!pq.isEmpty())
                answer += pq.poll();
        }
        bw.write(answer + "");		//가치의 합 BufferedWriter 저장
        bw.flush();		//결과 출력
        bw.close();
        br.close();
    }
}

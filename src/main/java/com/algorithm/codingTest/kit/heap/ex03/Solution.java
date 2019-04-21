package com.algorithm.codingTest.kit.heap.ex03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;


/**
 * 
 * 디스크 컨트롤러
문제 설명
하드디스크는 한 번에 하나의 작업만 수행할 수 있습니다. 디스크 컨트롤러를 구현하는 방법은 여러 가지가 있습니다. 가장 일반적인 방법은 요청이 들어온 순서대로 처리하는 것입니다.

예를들어

- 0ms 시점에 3ms가 소요되는 A작업 요청
- 1ms 시점에 9ms가 소요되는 B작업 요청
- 2ms 시점에 6ms가 소요되는 C작업 요청
와 같은 요청이 들어왔습니다. 이를 그림으로 표현하면 아래와 같습니다.
Screen Shot 2018-09-13 at 6.34.58 PM.png

한 번에 하나의 요청만을 수행할 수 있기 때문에 각각의 작업을 요청받은 순서대로 처리하면 다음과 같이 처리 됩니다.
Screen Shot 2018-09-13 at 6.38.52 PM.png

- A: 3ms 시점에 작업 완료 (요청에서 종료까지 : 3ms)
- B: 1ms부터 대기하다가, 3ms 시점에 작업을 시작해서 12ms 시점에 작업 완료(요청에서 종료까지 : 11ms)
- C: 2ms부터 대기하다가, 12ms 시점에 작업을 시작해서 18ms 시점에 작업 완료(요청에서 종료까지 : 16ms)
이 때 각 작업의 요청부터 종료까지 걸린 시간의 평균은 10ms(= (3 + 11 + 16) / 3)가 됩니다.

하지만 A → C → B 순서대로 처리하면
Screen Shot 2018-09-13 at 6.41.42 PM.png

- A: 3ms 시점에 작업 완료(요청에서 종료까지 : 3ms)
- C: 2ms부터 대기하다가, 3ms 시점에 작업을 시작해서 9ms 시점에 작업 완료(요청에서 종료까지 : 7ms)
- B: 1ms부터 대기하다가, 9ms 시점에 작업을 시작해서 18ms 시점에 작업 완료(요청에서 종료까지 : 17ms)
이렇게 A → C → B의 순서로 처리하면 각 작업의 요청부터 종료까지 걸린 시간의 평균은 9ms(= (3 + 7 + 17) / 3)가 됩니다.

각 작업에 대해 [작업이 요청되는 시점, 작업의 소요시간]을 담은 2차원 배열 jobs가 매개변수로 주어질 때, 
작업의 요청부터 종료까지 걸린 시간의 평균을 가장 줄이는 방법으로 처리하면 평균이 얼마가 되는지 return 하도록 
solution 함수를 작성해주세요. (단, 소수점 이하의 수는 버립니다)

제한 사항
jobs의 길이는 1 이상 500 이하입니다.
jobs의 각 행은 하나의 작업에 대한 [작업이 요청되는 시점, 작업의 소요시간] 입니다.
각 작업에 대해 작업이 요청되는 시간은 0 이상 1,000 이하입니다.
각 작업에 대해 작업의 소요시간은 1 이상 1,000 이하입니다.
하드디스크가 작업을 수행하고 있지 않을 때에는 먼저 요청이 들어온 작업부터 처리합니다.

입출력 예
jobs						return
[[0, 3], [1, 9], [2, 6]]	9

입출력 예 설명
문제에 주어진 예와 같습니다.

0ms 시점에 3ms 걸리는 작업 요청이 들어옵니다.
1ms 시점에 9ms 걸리는 작업 요청이 들어옵니다.
2ms 시점에 6ms 걸리는 작업 요청이 들어옵니다.
 * 
 * @author ykc
 *
 */
public class Solution {
	
	public class Disk implements Comparable<Disk> {
		int start;
		int time;
		
		public Disk(int start, int time) {
			this.start = start;
			this.time = time;
		}
		public int compareTo(Disk compDisk) {
			if(this.time >= compDisk.time) {
				return 1;
			}
			return -1;
		}
		public String toString() {
			return "Disk [start=" + start + ", time=" + time + "]";
		}
	}
	
	public int solution(int[][] jobs) {
		PriorityQueue<Disk> pq = new PriorityQueue<>();		
		List<Integer> removeIndex = new ArrayList<Integer>();
		int locTime = 0;
		int i = 0;
		int totalTime = 0;
		
		Arrays.sort(jobs, new Comparator<int[]>() {
			public int compare(int[] o1, int[] o2) {
				if (o1[0] > o2[0]) {
					return 1;
				}
				return -1;
			}
		});
		
		while(i < jobs.length) {
			for(int j = 0; j < jobs.length; j++) {
				int start = jobs[j][0];
				int time = jobs[j][1];
				
				if(removeIndex.contains(j)) continue;
				
				if(locTime >= start) {
					pq.offer(new Disk(start, time));
					removeIndex.add(j);
				}
			}
			System.out.println(pq);
			
			if (pq.size() == 0) {
				locTime = jobs[i][0];
				continue;
			}
			
			if(pq.size() > 0) {
				Disk disk = pq.poll();
				locTime += disk.time;
				totalTime += locTime - disk.start;
			}
			
			i++;
		}
		
		System.out.println("결과 : " + totalTime);
		
		return totalTime / jobs.length;
	}
	
	public int solution2(int[][] jobs) {
		Arrays.sort(jobs, new Comparator<int[]>() {
			public int compare(int[] o1, int[] o2) {
				if (o1[0] > o2[0]) {
					return 1;
				}
				return -1;
			}
		});

		PriorityQueue<int[]> queue = new PriorityQueue<int[]>(new Comparator<int[]>() {
			public int compare(int[] o1, int[] o2) {
				if (o1[1] >= o2[1]) {
					return 1;
				}
				return -1;
			}
		});

		int time = 0;
		int index = 0;
		int answer = 0;
		while (true) {
			while (index < jobs.length && jobs[index][0] <= time) {
				queue.offer(jobs[index]);
				index++;
			}
			
			if (queue.size() == 0) {
				time = jobs[index][0];
				continue;
			}
			int[] job = queue.poll();
			time += job[1];
			answer += time - job[0];
			if (index == jobs.length && queue.size() == 0) {
				break;
			}
		}

		answer /= jobs.length;
		return answer;
	}
	
	public static void main(String[] args) {
		//int[][] jobs = {{0,3},{1,9},{2,6}};
		//int[][] jobs = {{0,9},{0,4},{0,5},{0,7},{0,3}}; //13
		//int[][] jobs = {{0,9},{1,3},{2,5}};
		//int[][] jobs = {{0,3},{1,9},{2,6},{4,3}}; //9
		int[][] jobs = {{1,3},{1,9},{2,6},{4,3}}; 
		
		Solution solution = new Solution();
		int answer = solution.solution(jobs);
		System.out.println(answer);
	}

}

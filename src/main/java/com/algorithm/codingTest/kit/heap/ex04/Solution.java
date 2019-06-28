package com.algorithm.codingTest.kit.heap.ex04;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 
 * 이중우선순위큐
문제 설명
이중 우선순위 큐는 다음 연산을 할 수 있는 자료구조를 말합니다.

명령어	수신 탑(높이)
I 숫자	큐에 주어진 숫자를 삽입합니다.
D 1		큐에서 최댓값을 삭제합니다.
D -1	큐에서 최솟값을 삭제합니다.

이중 우선순위 큐가 할 연산 operations가 매개변수로 주어질 때, 모든 연산을 처리한 후 큐가 비어있으면 [0,0] 
비어있지 않으면 [최댓값, 최솟값]을 return 하도록 solution 함수를 구현해주세요.

제한사항
operations는 길이가 1 이상 1,000,000 이하인 문자열 배열입니다.
operations의 원소는 큐가 수행할 연산을 나타냅니다.
원소는 “명령어 데이터” 형식으로 주어집니다.- 최댓값/최솟값을 삭제하는 연산에서 최댓값/최솟값이 둘 이상인 경우, 하나만 삭제합니다.
빈 큐에 데이터를 삭제하라d는 연산이 주어질 경우, 해당 연산은 무시합니다.

입출력 예
operations				return
[I 16,D 1]				[0,0]
[I 7,I 5,I -5,D -1]		[7,5]

입출력 예 설명
16을 삽입 후 최댓값을 삭제합니다. 비어있으므로 [0,0]을 반환합니다.
7,5,-5를 삽입 후 최솟값을 삭제합니다. 최대값 7, 최소값 5를 반환합니다.

 * 
 * @author ykc
 *
 */
public class Solution {

	public int[] solution(String[] operations) {
		int[] answer = new int[2];
		List<Integer> list = new ArrayList<Integer>();
		
		for(String op : operations) {
			String gubun = op.split(" ")[0];
			Integer number = Integer.parseInt(op.split(" ")[1]);
			
			if("I".equals(gubun)) {
				list.add(number);
			}
			else if("D".equals(gubun)) {
				if(number == -1) {
					if(list.size() > 0) {
						Collections.sort(list);
						list.remove(0);
					}
				} else {
					if(list.size() > 0) {
						Collections.sort(list, (a, b) -> a < b ? 1 : -1);
						list.remove(0);
					}
				}
			}
		}
		
		System.out.println(list);
		
		if(list.size() > 0) {
			Collections.sort(list);
			if(list.size() == 1) {
				answer[0] = list.get(0);
				answer[1] = list.get(0);
			} else {
				answer[1] = list.get(0);
				
				Collections.sort(list, (a, b) -> a < b ? 1 : -1);
				answer[0] = list.get(0);
			}
		} else {
			answer[0] = 0;
			answer[1] = 0;
		}
		
		return answer;
	}
	
	public int[] solution2(String[] operations) {
		int[] answer = new int[2];
		PriorityQueue<Integer> minQueue = new PriorityQueue<Integer>();
		PriorityQueue<Integer> maxQueue = new PriorityQueue<Integer>(new Comparator<Integer>() {
			public int compare(Integer o1, Integer o2) {
				return o1 < o2 ? 1 : -1;
			}
		});
		
		for(String op : operations) {
			if("I".equals(op.split(" ")[0])) {
				Integer number = Integer.parseInt(op.split(" ")[1]);
				minQueue.offer(number);
				maxQueue.offer(number);
			}
			else if("D 1".equals(op)) {
				if(!maxQueue.isEmpty()) {
					minQueue.remove(maxQueue.poll());
				}
			}
			else if("D -1".equals(op)) {
				if(!minQueue.isEmpty()) {
					maxQueue.remove(minQueue.poll());
				}
			}
		}
		System.out.println("minQueue : " + minQueue + " maxQueue : " + maxQueue);
		
		if(!maxQueue.isEmpty()) {
			answer[0] = maxQueue.poll();
		}
		if(!minQueue.isEmpty()) {
			answer[1] = minQueue.poll();
		}

		return answer;
	}
	
	public static void main(String[] args) {
		//String[] operations = {"I 16", "D 1"};
		//String[] operations = {"I 7", "I 5", "I -5", "D -1"};
		//String[] operations = {"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"}; //0, 0
		String[] operations = {"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"}; //333, -45
		
		Solution solution = new Solution();
		int[] answer = solution.solution2(operations);
		for(int a : answer) {
			System.out.print(a + ", ");
		}
	}
}

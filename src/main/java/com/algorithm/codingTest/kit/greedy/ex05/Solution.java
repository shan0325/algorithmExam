package com.algorithm.codingTest.kit.greedy.ex05;

import java.util.HashSet;
import java.util.Set;

public class Solution {
	
	public int solution(int n, int[][] costs) {
		int answer = 0;
		
		Set<Integer> set = new HashSet<Integer>();
		Set<Integer> indexSet = new HashSet<Integer>();
		Set<Integer> continueSet = new HashSet<Integer>();
		int minCost = Integer.MAX_VALUE;
		int minIndex = 0;
		int index = 0;
		while(n > set.size()) {
			if(index == costs.length) {
				if( set.size() == 0 || (set.contains(costs[minIndex][0]) || set.contains(costs[minIndex][1])) 
						&& (!set.contains(costs[minIndex][0]) || !set.contains(costs[minIndex][1])) ) {
					set.add(costs[minIndex][0]);
					set.add(costs[minIndex][1]);
					answer += costs[minIndex][2];
					indexSet.add(minIndex);
					
					continueSet = new HashSet<Integer>();
					
					System.out.println("s : " + costs[minIndex][0]);
					System.out.println("e : " + costs[minIndex][1]);
					System.out.println("minCost : " + costs[minIndex][2]);
					System.out.println("indexSet : " + indexSet);
					System.out.println("set : " + set);
					System.out.println("=====================================");
				} else {
					continueSet.add(minIndex);
				}
				
				minCost = Integer.MAX_VALUE;
				index = 0;
				continue;
			}
			
			if(indexSet.contains(index) || continueSet.contains(index)) {
				index++;
				continue;
			}
			
			if(minCost > costs[index][2]) {
				minCost = costs[index][2];
				minIndex = index;
			}
			
			index++;
		}
		
		return answer;
	}

	public static void main(String[] args) {
		int n = 6;
//		int costs[][] = {{0,1,1}, {0,2,2}, {1,2,5}, {1,3,1}, {2,3,8}};
//		int costs[][] = {{0,1,8}, {0,2,2}, {1,2,5}, {1,3,1}, {2,3,1}};
//		int costs[][] = {{0,1,5}, {1,2,3}, {2,3,3}, {3,1,2}, {3,0,4}};  //n = 4, answer : 9
		int costs[][] = {{0, 1, 5}, {0, 3, 2}, {0, 4, 3}, {1, 4, 1}, {3, 4, 10}, {1, 2, 2}, {2, 5, 3}, {4, 5, 4}};  //n = 6, answer : 11
		
		//{0, 3, 2}, {0, 4, 3}, {1, 4, 1}, {1, 2, 2}, {2, 5, 3}
		
		Solution solution = new Solution();
		int answer = solution.solution(n, costs);
		System.out.println(answer);
	}
}

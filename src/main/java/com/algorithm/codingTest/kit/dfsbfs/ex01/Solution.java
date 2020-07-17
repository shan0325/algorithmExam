package com.algorithm.codingTest.kit.dfsbfs.ex01;


/**
 * n개의 음이 아닌 정수가 있습니다. 이 수를 적절히 더하거나 빼서 타겟 넘버를 만들려고 합니다. 예를 들어 [1, 1, 1, 1, 1]로 숫자 3을 만들려면 다음 다섯 방법을 쓸 수 있습니다.

-1+1+1+1+1 = 3
+1-1+1+1+1 = 3
+1+1-1+1+1 = 3
+1+1+1-1+1 = 3
+1+1+1+1-1 = 3

사용할 수 있는 숫자가 담긴 배열 numbers, 타겟 넘버 target이 매개변수로 주어질 때 숫자를 적절히 더하고 빼서 타겟 넘버를 만드는 방법의 수를 return 하도록 solution 함수를 작성해주세요.

제한사항
주어지는 숫자의 개수는 2개 이상 20개 이하입니다.
각 숫자는 1 이상 50 이하인 자연수입니다.
타겟 넘버는 1 이상 1000 이하인 자연수입니다.

입출력 예
numbers				target		return
[1, 1, 1, 1, 1]		3			5

 * @author ykc
 *
 */
public class Solution {
	
    public int solution(int[] numbers, int target) {        
        int answer = 0;
        
        int n = numbers.length;
        boolean[] visited = new boolean[n];
        for (int i = 1; i <= n; i++) {
        	answer += combination(numbers, visited, 0, n, i, target);
		}
     
        return answer;
	}
    
    public int combination(int[] arr, boolean[] visited, int start, int n, int r, int target) {
		if(r == 0) {
			int sum = 0;
			for (int i = 0; i < n; i++) {
	            if (visited[i]) {
	            	sum -= arr[i];
	            } else {
	            	sum += arr[i];
	            }
	        }
			
			if(sum == target) {
				return 1;
			}
	        return 0;
		}
		
		int result = 0;
		for (int i = start; i < n; i++) {
			visited[i] = true;
			result += combination(arr, visited, i + 1, n, r - 1, target);
			visited[i] = false;
		}
		return result;
	}
	
	
	public static void main(String[] args) {
		int[] numbers = {1,1,1,1,1}; int target = 3; // 5
//		int[] numbers = {1,2,1,2,1}; int target = 3;
//		int[] numbers = {1,2,1,2,2}; int target = 4;
//		int[] numbers = {1,2,3}; int target = 2;
//		int[] numbers = {2,3,5,7,9}; int target = 2;
		
		
		Solution solution = new Solution();
		int answer = solution.solution(numbers, target);
		System.out.println("answer : " + answer);
	}
}

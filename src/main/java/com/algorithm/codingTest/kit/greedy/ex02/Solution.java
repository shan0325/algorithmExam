package com.algorithm.codingTest.kit.greedy.ex02;


/**
 * 
 * 조이스틱
문제 설명
조이스틱으로 알파벳 이름을 완성하세요. 맨 처음엔 A로만 이루어져 있습니다.
ex) 완성해야 하는 이름이 세 글자면 AAA, 네 글자면 AAAA

조이스틱을 각 방향으로 움직이면 아래와 같습니다.

▲ - 다음 알파벳
▼ - 이전 알파벳 (A에서 아래쪽으로 이동하면 Z로)
◀ - 커서를 왼쪽으로 이동 (첫 번째 위치에서 왼쪽으로 이동하면 마지막 문자에 커서)
▶ - 커서를 오른쪽으로 이동
예를 들어 아래의 방법으로 JAZ를 만들 수 있습니다.

- 첫 번째 위치에서 조이스틱을 위로 9번 조작하여 J를 완성합니다.
- 조이스틱을 왼쪽으로 1번 조작하여 커서를 마지막 문자 위치로 이동시킵니다.
- 마지막 위치에서 조이스틱을 아래로 1번 조작하여 Z를 완성합니다.
따라서 11번 이동시켜 "JAZ"를 만들 수 있고, 이때가 최소 이동입니다.
만들고자 하는 이름 name이 매개변수로 주어질 때, 이름에 대해 조이스틱 조작 횟수의 최솟값을 return 하도록 solution 함수를 만드세요.

제한 사항
name은 알파벳 대문자로만 이루어져 있습니다.
name의 길이는 1 이상 20 이하입니다.

입출력 예
name		return
JEROEN		56
JAN			23
 * 
 * @author ykc
 *
 */
public class Solution {

	public int solution(String name) {
		int answer = 0;
		int startNo = 65;
		char[] names = name.toCharArray();
		
		int loc = 0;
		while(true) {
			boolean isEsc = true;
			for(int i = 0; i < names.length; i++) {
				if(names[i] != 'A') {
					isEsc = false;
					break;
				}
			}
			if(isEsc) break;
			
			int front = 0;
			int back = 0;
			for(int i = loc; i < names.length; i++) {
				if(names[i] - startNo != 0) break;
				front++;
				if(i == names.length - 1) i = -1;
			}
			for(int i = loc; i >= 0; i--) {
				if(names[i] - startNo != 0) break;
				back++;
				if(i == 0) i = names.length;
			}
			System.out.println("loc : " + loc + " / " + "front : " + front + " / back : " + back);
			
			if(front == back) {
				if(front > 0)  {
					answer++;
					loc++;
				}
			} else if(front < back) {
				answer += front;
				if(loc + front > names.length - 1) {
					loc = loc + front - names.length;
				} else {
					loc += front;
				}
			} else {
				answer += back;
				if(loc - back < 0) {
					loc = loc - back + names.length;
				} else {
					loc -= back;
				}
			}
			
			int engIndex = names[loc] - startNo;
			if(engIndex <= 12) {
				answer += engIndex;
			} else {
				answer += 26 - engIndex;
			}
			System.out.println("loc : " + loc + " / " + names[loc] + " : " + engIndex + " / answer : " + answer);
			
			names[loc] = 'A';
		}
		return answer;
	}
	
	public static void main(String[] args) {
		String name = "ABAAAAAAABA"; // 6
//		String name = "JEROEN";	// 56
//		String name = "JAN"; // 23
//		String name = "AABAAAAAAABBB"; // 12
		
		Solution solution = new Solution();
		int answer = solution.solution(name);
		System.out.println(answer);
	}
}

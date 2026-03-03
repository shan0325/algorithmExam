package com.algorithm.codingTest.kit.hash.ex04;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 
 * 베스트앨범
문제 설명
스트리밍 사이트에서 장르 별로 가장 많이 재생된 노래를 두 개씩 모아 베스트 앨범을 출시하려 합니다. 노래는 고유 번호로 구분하며, 노래를 수록하는 기준은 다음과 같습니다.

속한 노래가 많이 재생된 장르를 먼저 수록합니다.
장르 내에서 많이 재생된 노래를 먼저 수록합니다.
장르 내에서 재생 횟수가 같은 노래 중에서는 고유 번호가 낮은 노래를 먼저 수록합니다.
노래의 장르를 나타내는 문자열 배열 genres와 노래별 재생 횟수를 나타내는 정수 배열 plays가 주어질 때, 베스트 앨범에 들어갈 노래의 고유 번호를 순서대로 return 하도록 solution 함수를 완성하세요.

제한사항
genres[i]는 고유번호가 i인 노래의 장르입니다.
plays[i]는 고유번호가 i인 노래가 재생된 횟수입니다.
genres와 plays의 길이는 같으며, 이는 1 이상 10,000 이하입니다.
장르 종류는 100개 미만입니다.
장르에 속한 곡이 하나라면, 하나의 곡만 선택합니다.
모든 장르는 재생된 횟수가 다릅니다.

입출력 예
genres									plays						return
[classic, pop, classic, classic, pop]	[500, 600, 150, 800, 2500]	[4, 1, 3, 0]

입출력 예 설명
classic 장르는 1,450회 재생되었으며, classic 노래는 다음과 같습니다.

고유 번호 3: 800회 재생
고유 번호 0: 500회 재생
고유 번호 2: 150회 재생
pop 장르는 3,100회 재생되었으며, pop 노래는 다음과 같습니다.

고유 번호 4: 2,500회 재생
고유 번호 1: 600회 재생
따라서 pop 장르의 [4, 1]번 노래를 먼저, classic 장르의 [3, 0]번 노래를 그다음에 수록합니다.
 * 
 * @author ykc
 *
 */
public class Solution {
	
	public int[] solution(String[] genres, int[] plays) {
		Map<String, Integer> tempMap = new HashMap<>();
		Map<String, Integer> sumMap = new HashMap<>();
		
		for(int i = 0; i < genres.length; i++) {
			if(sumMap.containsKey(genres[i])) {
				sumMap.put(genres[i], sumMap.get(genres[i]) + plays[i]);
			} else {
				sumMap.put(genres[i], plays[i]);
			}
			
			tempMap.put(genres[i] + "_" + i, plays[i]);
		}
		System.out.println(tempMap);
		System.out.println(sumMap);
		
		List<String> sumList = sortByValue(sumMap);
		List<String> tempList = sortByValue(tempMap);
		
		System.out.println(sumList);
		System.out.println(tempList);
		
		List<Integer> indexList = new ArrayList<>();
		for(String sum : sumList) {
			int j = 0;
			for(String temp : tempList) {
				String index = temp.substring(temp.lastIndexOf("_") + 1);
				if(temp.contains(sum) && j < 2) {
					indexList.add(Integer.parseInt(index));
					j++;
				}
			}
		}
		System.out.println(indexList);
		
		int[] answer = new int[indexList.size()];
		for(int i = 0; i < indexList.size(); i++) {
			answer[i] = indexList.get(i);
		}
		
		return answer;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static List<String> sortByValue(final Map map) {
		List<String> list = new ArrayList();
		list.addAll(map.keySet());
		
		Collections.sort(list, (o1, o2) -> {
			Object v1 = map.get(o1);
			Object v2 = map.get(o2);
			
			String o1Index = o1.substring(o1.lastIndexOf("_") + 1);
			String o2Index = o2.substring(o2.lastIndexOf("_") + 1);
			
			int compareTo = ((Comparable)v2).compareTo(v1);
			if(compareTo == 0) { 
				return o1Index.compareTo(o2Index); 
			}
			return compareTo;
		});
		
		return list;
	}

	public static void main(String[] args) {
		String[] genres = {"classic", "pop", "classic", "classic", "pop", "pop"};
		int[] plays = {500, 600, 150, 800, 2500, 600};
		
		Solution solution = new Solution();
		int[] answer = solution.solution(genres, plays);
		
//		Integer[] array = { 6, 4, 2, 7, 5, 3, 1, 9, 8, 0 };
//		int prev = 0;
//		for (int i = 0; i < array.length; i++) {
//			for (int j = i + 1; j < array.length; j++) {
//				if (array[i] > array[j]) {
//					prev = array[i];
//					array[i] = array[j];
//					array[j] = prev;
//				}
//			}
//		}
//		Arrays.asList(array).forEach(System.out::print);
		 
		
	}
}

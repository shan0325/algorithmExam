package com.algorithm.코테.메조미디어;

/**
 * 중고차 딜러는 중고차를 사고 팔아 이익을 내려고 합니다. 중고차는 매일매일 가격이 변합니다. 중고차를 사거나 팔려고 할 때는 그날의 중고차 가격으로만 거래할 수 있습니다. 또, 중고차는 주어진 기간동안 단 한번만 구매 후 판매할 수 있습니다.
 * n일 동안의 중고차 가격이 들어있는 배열(prices)이 입력으로 주어질 때 얻을 수 잇는 최대 이익을 return 하도록 solution 함수를 완성해 주세요. 배열의 i번째 요소는 i번째 날의 중고차 가격을 나타냅니다. 예를 들어 5일간 중고차의 가격이 [3, 2, 4, 8, 7]
 * 인 경우 2원에 중고차를 구매하여 이를 후 8원에 팔면 6의 이익이 발생하고, 이때 최대 이익을 얻을 수 있습니다. 단, 이익이 발생하지 않을 때 는 중고차를 구매하지 않을 수도 있으며, 이때는 0을 return 합니다.
 */
public class Question1 {
    // 2중 for문 사용
    /*public int solution(int[] prices) {
        int answer = -1;

        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                int gain = prices[j] - prices[i];
                if (gain > answer) {
                    answer = gain;
                }
            }
        }
        return answer;
    }*/

    // 더 효율적인 방법으로
    public int solution(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price;
            } else {
                int profit = price - minPrice;
                if (profit > maxProfit) {
                    maxProfit = profit;
                }
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
//        int[] prices = {3, 2, 4, 8, 7}; // 6
//        int[] prices = {3, 4, 1, 5, 4}; // 4
//        int[] prices = {3, 5, 1, 3, 4}; // 3
        int[] prices = {3, 7, 1, 3, 4}; // 4

        Question1 question1 = new Question1();
        int answer = question1.solution(prices);
        System.out.println(answer);
    }
}

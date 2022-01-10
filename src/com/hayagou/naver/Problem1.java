package com.hayagou.naver;

public class Problem1 {

    public static void main(String[] args) {
        int[][] cards = {{10, 5, 15}, {5, 15, 10}, {10, 11, 9}};

        for (int[] card : cards) {
            Card c = new Card(card[0], card[1], card[2]);

        }
    }

    public static int solution(int[][] cards) {
        int answer = -1;
        return answer;
    }

    static class Card {
        int R, G, B;

        public Card(int R, int G, int B) {
            this.R = R;
            this.G = G;
            this.B = B;
        }
    }

}

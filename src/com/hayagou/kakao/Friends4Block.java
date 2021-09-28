package com.hayagou.kakao;

public class Friends4Block {
    public static int solution(int m, int n, String[] board) {
        int answer = 0;
        String[][] boardArray = new String[m][n];

        for (int i = 0; i < n; i++) {
            String[] temp = board[i].split("");
            for (int j = 0; j < m; j++) {
                boardArray[i][j] = temp[j];
            }
        }
// 출력
//        for (int i = 0; i < n; i++) {
//
//            for (int j = 0; j < m; j++) {
//                System.out.print(boardArray[i][j]);
//            }
//            System.out.println();
//        }

        String[][] mask = new String[4][4];

        for (int i = 0; i < n - 1; i++) {

            for (int j = 0; j < m - 1; j++) {
                mask[i][j] = boardArray[i][j];
                mask[i][j + 1] = boardArray[i][j + 1];
                mask[i + 1][j] = boardArray[i + 1][j];
                mask[i + 1][j + 1] = boardArray[i + 1][j + 1];
                if (mask[i][j].equalsIgnoreCase(mask[i][j + 1]) &&
                        mask[i][j].equalsIgnoreCase(mask[i][j + 1]) &&
                        mask[i][j].equalsIgnoreCase(mask[i + 1][j]) &&
                        mask[i][j].equalsIgnoreCase(mask[i + 1][j + 1])
                ){
                    mask[i][j] = boardArray[i][j];
                    mask[i][j + 1] = boardArray[i][j + 1];
                    mask[i + 1][j] = boardArray[i + 1][j];
                    mask[i + 1][j + 1] = boardArray[i + 1][j + 1];
                }
            }
        }


        return answer;
    }

    public static void main(String[] args) {
        int m = 6;
        int n = 6;
        String[] board = {"TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"};
        System.out.println(solution(m, n, board));
    }
}

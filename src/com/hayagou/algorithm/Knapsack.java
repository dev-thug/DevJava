//package com.hayagou.algorithm;
//
//import java.util.Scanner;
//
//public class DP3_KnapsackTest {
//    /*
//    4
//    10
//    5 10
//    4 40
//    6 30
//    3 50
//    * */
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int N = sc.nextInt();   //물건개수
//        int W = sc.nextInt();   //목표무게
//        int[] weights = new int[N+1];
//        int[] profits = new int[N+1];
//
//        for (int i = 1; i <= N ; i++) {
//            weights[i] = sc.nextInt();
//            profits[i] = sc.nextInt();
//        }
//        int[][] D  = new int[N+1][W+1];
//        for (int i = 1; i <= N; i++) {
//            for(int w = 1; w <= W ; w++){
//                if(weights[i]<=w){//하중이내
//                    D[i][w] = Math.max(D[i-1][w],profits[i]+D[i-1][w-weights[i]]);  //현재 물건 가치vs잔여무게(이전무게까지 최적가치)
//                }else{//하중초과
//                    D[i][w] = D[i-1][w];
//                }
//            }
//        }
//        System.out.println(D[N][W]);
//        for (int i = 0; i <=N ; i++) {
//            for(int j = 0 ; j <=W ; j++){
//                System.out.print(D[i][j]+"\t");
//            }
//            System.out.println();
//        }
//        for (int i = 1; i <=N ; i++) {
//            System.out.print(weights[i]+"\t");
//        }
//    }
//
//}

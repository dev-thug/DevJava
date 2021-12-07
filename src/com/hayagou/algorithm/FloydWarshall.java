package com.hayagou.algorithm;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
/*
20
5 0 1 1 0 0 1 0 1 1 1 1 1 0 0 0 0 1 0 0 0 0 1 0 0 0...
노드당 모든노드에 대한 가중치(sum)
 */
public class FloydWarshall {
//
    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("src/wx/sw1263/input.txt"));
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int test_case = 1 ; test_case<=T ; test_case++){
            int N = sc.nextInt();
            int[][] mat = new int[N+1][N+1];
            for(int i = 1 ; i <= N ; i++){
                for(int j = 1 ; j <= N ; j++){
                    mat[i][j] = sc.nextInt();
                    if(mat[i][j]==0&&i!=j) mat[i][j] = 10000000;
                }
            }
            for(int k = 1 ; k <= N; k++){
                for(int i = 1 ; i <= N ; i++){
                    for(int j = 1 ; j <= N ; j++){
                        mat[i][j] = Math.min(mat[i][k]+mat[k][j],mat[i][j]);
                    }
                }
            }
            long result = 10000000;
            for (int i = 1; i <= N ; i++) {
                long sum = 0;
                for (int j = 1; j <= N ; j++) {
                    sum+=mat[i][j];
                }
                result = Math.min(sum,result);
            }
            System.out.println("#"+test_case+" "+result);

        }
    }
}

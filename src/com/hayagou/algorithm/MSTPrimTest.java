package com.hayagou.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
5
0 5 10 8 7
5 0 5 3 6
10 5 0 1 3
8 3 1 0 1
7 6 3 1 0

output==>10

7
0 32 31 0 0 60 51
32 0 21 0 0 0 0
31 21 0 0 46 0 25
0 0 0 0 34 18 0
0 0 46 34 0 40 51
60 0 0 18 40 0 0
51 0 25 0 51 0 0

output==>175
* */
public class MSTPrimTest {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine());
        int[][] adjMatrix = new int[N][N];
        boolean[] visited = new boolean[N];     //신장트리 방문여부
        int[] minEdge = new int[N];
        StringTokenizer st = null;
        for (int i = 0; i <N ; i++) {
            st = new StringTokenizer(in.readLine());
            for (int j = 0; j <N ; j++) {
                adjMatrix[i][j] = Integer.parseInt(st.nextToken());
            }
            minEdge[i] = Integer.MAX_VALUE;     //최소 길이 무한대로 초기화
        }
        int result = 0;     //최소신장트리 비용
        minEdge[0] = 0;     //임의의 시작점 0의 간선비용을 0으로 셋팅(굳이 0이아니더라도 비용만 같으면, 상관없음)
        for (int i = 0; i < N; i++) {
            //1. 신장트리의 포함되지 않은 정점 중에 최소간선비용의 정점 찾기
            int min = Integer.MAX_VALUE;
            int minVertex = -1;         // 최소간선비용의 정점 번호
            for (int j = 0; j < N; j++) {
                if(!visited[j] && min > minEdge[j]){    //방문안한 정점중에서 기존 최솟값보다 작을경우
                    min = minEdge[j];
                    minVertex = j;
                }
            }
            visited[minVertex] = true;  //신장트리에 포함시킴
            result += min;              //간선비용 누적

            //2. 선택된 정점 기준으로 신장트리에 연결되지 않은 타 정점과의 간선 비용 최소로 Update
            for (int j = 0; j <N ; j++){
                if(!visited[j] && adjMatrix[minVertex][j]!=0 && minEdge[j]> adjMatrix[minVertex][j]){   //방문x , 인접(!0), 최소 비용 보다 작을시
                    minEdge[j] = adjMatrix[minVertex][j];
                }
            }
        }
        System.out.println(result);
    }
}

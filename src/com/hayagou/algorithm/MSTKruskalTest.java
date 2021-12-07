package com.hayagou.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/*
input형식

5 10
0 1 5
0 2 10
0 3 8
0 4 7
1 2 5
1 3 3
1 4 6
2 3 1
2 4 3
3 4 1

output==>10

7 11
0 1 32
0 2 31
0 5 60
0 6 51
1 2 21
2 4 46
2 6 25
3 4 34
3 5 18
4 5 40
4 6 51

output==>175

*/
public class MSTKruskalTest {
    static class Edge implements Comparable<Edge>{
        int start,end,weight;
        public Edge(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(weight,o.weight);
        }
    }
    static int V,E;
    static Edge[] edgeList;

    //disjoint 부분
    static int N;           //원소개수
    static int[] parents;   //부모 원소를 관리(트리처럼 사용)

    private static void make(){
        parents = new int[V];
        for(int i = 0; i < V ; i++){
            parents[i] = i;
        }
    }
    //A 속한 잡합의 대표자 찾기
    private static int find(int a){
        if(a==parents[a]) return a;
        return parents[a] = find(parents[a]);
    }

    //두 원소를 하나의 집합으로 합치기(대표자를 이용해서 합침)
    private static boolean union(int a, int b){
        int aRoot = find(a);
        int bRoot = find(b);
        if(aRoot == bRoot) return false;

        parents[bRoot] = aRoot;
        return true;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine()," ");
        V = Integer.parseInt(st.nextToken());               // 정점(Vertex) 개수
        E = Integer.parseInt(st.nextToken());               // 간선(Edge) 개수

        //간선 리스트작성
        edgeList = new Edge[E];
        for(int i = 0 ; i < E ; i++){
            st = new StringTokenizer(in.readLine()," ");
            int start =  Integer.parseInt(st.nextToken());
            int end =  Integer.parseInt(st.nextToken());
            int weight =  Integer.parseInt(st.nextToken());
            edgeList[i] = new Edge(start,end,weight);
        }
        Arrays.sort(edgeList);

        make(); //모든 정점을 각각의 집합으로 만들고 출발

        //간선 하나씩 시도하며 트리 만들어감
        int cnt= 0;
        int result = 0;
        for (Edge edge: edgeList) {
            if(union(edge.start, edge.end)){
                result += edge.weight;
                if(++cnt == V-1) break;     // 신장트리 완성
            }
        }
        System.out.println(result);

    }
}



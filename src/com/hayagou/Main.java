package com.hayagou;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
public class Main {
    static int N;
    static int[] dp;
    static final int INF = 1000000000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new int[N+1];
        Arrays.fill(dp,INF);
        for(int i = 1 ; i <= N ; i++){
            if(i%5==0){
                dp[i] = i/5;
            }
            else if(i%3==0){
                dp[i] = i/3;
            }
            else{
                if(i<5) continue;
                dp[i] = Math.min(dp[i-5]+1, dp[i-3]+1);
            }
        }
        if(dp[N]>=INF) System.out.println(-1);
        else System.out.println(dp[N]);
        System.out.println(Arrays.toString(dp));
    }
}

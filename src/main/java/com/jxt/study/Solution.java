package com.jxt.study;
/*
爬楼梯
1.穷举法
2.动态规划
 */
public class Solution {
    public static void main(String[] args) {
//        System.out.println(climbStairs(0, 5));
//        System.out.println(climbStairs(5));
        System.out.println(reverser(-364235589));
    }
    //爬楼梯
    public static int climbStairs(int i,int n){
        if (i > n){
            return 0;
        } else if (i == n){
            return 1;
        }

        return climbStairs(i + 1, n)+climbStairs(i + 2, n);
    }
    public static int climbStairs(int n){
        if (n == 1){
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n ; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
    //整数反转
    public static int reverser(int x){
        int ans = 0;
        while(x != 0){
            int pop = x % 10;
            if (ans > Integer.MAX_VALUE / 10 || (ans == Integer.MAX_VALUE / 10 && pop > 7)){
                return 0;
            }else if (ans < Integer.MIN_VALUE /10 ||(ans == Integer.MIN_VALUE / 10 && pop < -8)){
                return 0;
            }
            ans = ans * 10 + pop;
            x= x / 10;
        }
        return ans;

    }
}

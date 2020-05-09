package com.jxt.study;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
//        sum(new int[]{2, 7, 11, 15},20);
        twoSum(new int[]{2, 7, 11, 15},26);
    }
    public static void sum(int[] nums,int target){
        for (int i = 0; i < nums.length; i++) {
            int a = target - nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (a == nums[j]){
                    System.out.println("["+i+","+j+"]");
                }
            }
        }

    }
    public static int[] twoSum(int[] nums,int target){
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int value = target - nums[i];
            map.put(nums[i],i);
            if (map.containsKey(value)){
                System.out.println("["+i+","+map.get(value)+"]");
                return new int[] {i,map.get(value)};
            }


        }
        System.out.println("no");
        return null;

    }
}

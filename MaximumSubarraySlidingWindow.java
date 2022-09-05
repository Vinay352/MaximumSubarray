package Leetcode.Medium;

/**
 *
 * Author: Vinay Jain
 * Contact: vinay.j3097@gmail.com
 * Question: Maximum Subarray
 * Link: https://leetcode.com/problems/maximum-subarray/
 *
 * Sliding Window Approach
 */

public class MaximumSubarraySlidingWindow {
    public static void main(String[] args) {
        // int[] nums = {5,4,-1,7,8};

        // int[] nums = {8,-19,5,-4,20};

        // int[] nums = {-2,1,-3,4,-1,2,1,-5,4};

        // int[] nums = {-2,-1};

        // int[] nums = {-2, -3, -1};

        int[] nums = {3,-2,-3,-3,1,3,0};

//        for(int i =0; i< nums.length; i++){
//            System.out.println(nums[i]);
//        }

        System.out.println(maxSubArray(nums));
    }

    public static int maxSubArray(int[] nums){

        int maxSum = nums[0];
        int tempSum = nums[0];
        int reset;

        for(int i = 1; i < nums.length; i++){
            reset = 0;
            if(nums[i] >= 0 || nums[i] + tempSum >= 0){
                if(tempSum < 0){
                    tempSum = nums[i];
                }
                else{
                    tempSum += nums[i];
                }
            }
            else{

                if(nums[i] + tempSum <= 0 && tempSum > 0){
                    reset = 1;
                }
                if(tempSum <= nums[i]){
                    tempSum = nums[i];
                }
                else{
                    // do nothing
                }
            }
            maxSum = Math.max(maxSum, tempSum);
            if(reset == 1){
                tempSum = 0;
            }
        }
        return maxSum;
    }
}

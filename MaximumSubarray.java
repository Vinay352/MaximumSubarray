package Leetcode.Medium;

/**
 *
 * Author: Vinay Jain
 * Contact: vinay.j3097@gmail.com
 * Question: Maximum Subarray
 * Link: https://leetcode.com/problems/maximum-subarray/
 *
 * Dynamic Programming Solution optimized to O(n) from O(n^2)
 *
 * Works for some cases, not all
 */

public class MaximumSubarray {

    public static void main(String[] args) {
        // int[] nums = {5,4,-1,7,8};

        int[] nums = {8,-19,5,-4,20};

        // int[] nums = {-2,1,-3,4,-1,2,1,-5,4};

        // int[] nums = {-2,-1};

//        for(int i =0; i< nums.length; i++){
//            System.out.println(nums[i]);
//        }

        System.out.println(maxSubArray(nums));
    }

    public static int maxSubArray(int[] nums) {

        int[] array = nums; // main array

        int[] cum_sum = new int[nums.length];

        int max_sum = 0;

        int[] included = new int[nums.length];

        int startIndex = 0, endIndex = 0;


//        for(int i = 0; i < nums.length; i++){
//            System.out.println(array[i]);
//        }

        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                cum_sum[0] = array[0];
                max_sum = array[0];
                included[0] = 1;
                startIndex = endIndex = 0;
            } else {
                int curr_sum = max_sum;
                cum_sum[i] = cum_sum[i - 1] + array[i];
                included[i] = 0;

//                if( array[i] > curr_sum ){
//                    if(curr_sum <= 0){
//                        endIndex = i;
//                        startIndex = i;
//                        included[i] = 1;
//                        curr_sum = array[i];
//                    }
//                    else{
//                        endIndex = i;
//                        // startIndex = i;
//                        included[i] = 1;
//                        curr_sum = array[i] + curr_sum;
//                    }
//                }

//                if( array[i] > curr_sum ){
//                    endIndex = i;
//                    startIndex = i;
//                    included[i] = 1;
//                    curr_sum = array[i];
//                }

//                if(array[i] + array[i-1] > curr_sum){
//                    curr_sum = array[i] + array[i-1];
//                    startIndex = i - 1;
//                    endIndex = i;
//                    included[i] = 1;
//                }
//                if (included[i - 1] == 1 || array[i] > 0) {
//                    if(array[i] + curr_sum > curr_sum){
//                        curr_sum = array[i] + curr_sum;
//                        included[i] = 1;
//                        endIndex = i;
//                    }
                    if (array[i] > 0) {
                        if (curr_sum <= 0) {
                            endIndex = i;
                            startIndex = i;
                            included[i] = 1;
                            curr_sum = array[i];
                        } else if (included[i - 1] == 1) {
                            endIndex = i;
                            // startIndex = i;
                            included[i] = 1;
                            curr_sum = array[i] + curr_sum;
                        } else if (included[i - 1] == 0) {

                            int begin = startIndex == 0 ? 0 : startIndex - 1;

                            if(begin != 0){
                                if (array[i] + (cum_sum[i - 1] - cum_sum[begin]) > curr_sum) {
                                    curr_sum = array[i] + (cum_sum[i - 1] - cum_sum[begin]);
                                    endIndex = i;
                                    included[i] = 1;
                                }
                            }else{
                                if (array[i] + (cum_sum[i - 1]) > curr_sum) {
                                    curr_sum = array[i] + (cum_sum[i - 1]);
                                    endIndex = i;
                                    included[i] = 1;
                                }
                            }


                        }

//                        if(array[i] > curr_sum){
//                            endIndex = i;
//                            startIndex = i;
//                            included[i] = 1;
//                            curr_sum = array[i];
//                        }
                    }
                if(array[i] > curr_sum){
                    endIndex = i;
                    startIndex = i;
                    included[i] = 1;
                    curr_sum = array[i];
                }
//                } else if(included[i-1] == 0){
//                    if(array[i] + (cum_sum[i-1] - cum_sum[startIndex - 1]) > curr_sum){
//                        curr_sum = array[i] + (cum_sum[i-1] - cum_sum[startIndex - 1]);
//                        endIndex = i;
//                        included[i] = 1;
//                    }
//                }

                    max_sum = curr_sum;
            }

        }
        return max_sum;
    }
}

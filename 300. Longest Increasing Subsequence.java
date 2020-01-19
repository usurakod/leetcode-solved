/*
Given an unsorted array of integers, find the length of longest increasing subsequence.

Example:

Input: [10,9,2,5,3,7,101,18]
Output: 4 
Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4. 
******************************************************************************************************************************/

class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums.length == 0){return 0;}
        int maxAns = 1;
        int[] dp = new int[nums.length];
        dp[0]=1;
        for(int i=1;i<nums.length;i++){
            int maxVal=0;
            for(int j=0;j<i;j++){               
                if(nums[j]<nums[i]){                    
                  maxVal = Math.max(maxVal,dp[j]);
                }
            }
             dp[i] = maxVal+1;
             maxAns = Math.max(maxAns,dp[i]);
        }
        
        return maxAns;
    }
}

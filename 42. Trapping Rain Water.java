/* Given n non-negative integers representing an elevation map where the width of each bar is 1, 
compute how much water it is able to trap after raining.


The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. 
In this case, 6 units of rain water (blue section) are being trapped. Thanks Marcos for contributing this image!

****************************************************************************************************************************************/

Solution 1) 

class Solution {
    public int trap(int[] height) {
        int totalSize = height.length;
        int[] leftMax = new int[totalSize];
        int[] rightMax = new int[totalSize];
        
        if(height == null || totalSize ==0){
            return 0;
        }
        leftMax[0] = height[0];
        rightMax[totalSize-1] = height[totalSize-1];
        
        for(int i=1;i<totalSize;i++){
            leftMax[i]  = Math.max(height[i], leftMax[i-1]);
        }
        for(int j = totalSize-2;j>=0;j--){
            rightMax[j] = Math.max(height[j], rightMax[j+1]);
        }
        int ans=0;
        for(int i=1;i<totalSize-1;i++){
            ans += Math.min(leftMax[i],rightMax[i]) - height[i];
        }
        return ans;
    }
}

Solution 2)

class Solution {
    public int trap(int[] height) {
        int length = height.length;
        int leftPointer =0;
        int rightPointer = length-1;
        
        if(height == null ||height.length == 0){
            return 0;
        }
        int leftMax=0, rightMax=0, ans =0; 
        while(leftPointer < rightPointer){
            if(height[leftPointer] < height[rightPointer]){
                if(height[leftPointer] >= leftMax) {
                    leftMax = height[leftPointer];
                }else{
                    ans += leftMax - height[leftPointer];
                }
                leftPointer++;
            }
            else{
                if(height[rightPointer] >= rightMax){
                    rightMax = height[rightPointer];
                }
                else{
                    ans += rightMax - height[rightPointer];
                }
                rightPointer--;
            }
        }
        return ans;
    }
}

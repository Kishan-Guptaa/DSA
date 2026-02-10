class Solution {
    public int dominantIndex(int[] nums) {
        int maxIndex =  0 ;
        int n = nums.length;
        for(int i=1;i<n;i++){
            if(nums[i]>nums[maxIndex]){
                maxIndex = i;
            }
        }
        for(int i=0;i<n;i++){
            if(i!=maxIndex && nums[maxIndex]<2*nums[i]){
               return -1;
            }
        }
        return maxIndex;
    }
}
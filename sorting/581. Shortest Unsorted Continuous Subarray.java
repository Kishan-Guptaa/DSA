class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        int min = Integer.MAX_VALUE;
        int max  = Integer.MIN_VALUE;
        for(int i =1;i<n;i++){
            if(nums[i]<nums[i-1]){
                min = Math.min(min,nums[i]);
            }
        }
        for(int i = n-2;i>=0;i--){
            if(nums[i]>nums[i+1]){
                max = Math.max(max,nums[i]);
            }
        }
         if (min == Integer.MAX_VALUE) return 0;
        int l = 0;
        while(l<n && nums[l]<=min){
            l++;
        }
        int r = n-1;
        while(r>=0 && nums[r]>=max){
            r--;
        }
        return r - l +1;
    }
}
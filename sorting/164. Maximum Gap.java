// 164. Maximum Gap

class Solution {
    public int maximumGap(int[] nums) {
        int n = nums.length;
        if(n<2){
            return 0;
        }

        Arrays.sort(nums);
        int maxGAp = 0;
        for(int i=1;i<n;i++){
            maxGAp = Math.max(maxGAp,(nums[i] - nums[i-1]));
        }
        return maxGAp;
    }
}
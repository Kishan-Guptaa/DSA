class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        int n = nums.length;
        for(int i=0;i<=n-2;i++){
            for(int j=i+1;j<=n-1;j++){

                if(nums[i] + nums[j] == target){
                    res[0] = i;
                    res[1] = j;
                    return res;
                }
            }
        }
        return new int[] {-1,-1};
    }
}
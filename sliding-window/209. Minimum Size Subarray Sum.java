class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int[] prefix = new int[n+1];
        for(int i=1;i<=n;i++){
            prefix[i] = prefix[i-1] + nums[i-1];
        }
        int minLength = Integer.MAX_VALUE;

        for(int i=0;i<n;i++){
            int toFind = target + prefix[i];
            int bound = binarySearch(prefix,toFind);
            if(bound != -1){
                minLength = Math.min(minLength,bound-i);
            }
        }
        return (minLength == Integer.MAX_VALUE) ? 0 : minLength;
    }
    public int binarySearch(int[] prefix, int target){
        int n = prefix.length;
        int left = 0;
        int right = n-1;
        int ans = -1;
        while(left<=right){
            int mid = (left+right)/2;
            if(prefix[mid]>=target){
                ans= mid;
                right = mid - 1;
            }
            else{
                left = mid  +1;
            }
        }
        return ans;
    }
}
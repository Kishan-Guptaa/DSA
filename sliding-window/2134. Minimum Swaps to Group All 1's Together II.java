class Solution {
    public int minSwaps(int[] nums) {
        int n = nums.length;
        int totalOnes = 0;

        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) totalOnes++;
        }

        if (totalOnes == 0 || totalOnes == n) return 0;

        int zero = 0;

        
        for (int i = 0; i < totalOnes; i++) {
            if (nums[i] == 0) zero++;
        }

        int ans = zero;

       
        for (int i = totalOnes; i < n + totalOnes; i++) {
            if (nums[(i - totalOnes) % n] == 0) zero--; 
            if (nums[i % n] == 0) zero++;              
            ans = Math.min(ans, zero);
        }

        return ans;
    }
}

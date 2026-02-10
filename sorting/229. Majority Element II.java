class Solution {
   public static List<Integer> majorityElement(int[] nums){
        int n = nums.length;

        // Initialize with dummy values
        int val1 = 0, val2 = 1;
        int count1 = 0, count2 = 0;

        for (int num : nums) {
            if (num == val1) {
                count1++;
            } else if (num == val2) {
                count2++;
            } else if (count1 == 0) {
                val1 = num;
                count1 = 1;
            } else if (count2 == 0) {
                val2 = num;
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }

        // Verify the counts
        count1 = 0;
        count2 = 0;
        for (int val : nums) {
            if (val == val1) count1++;
            else if (val == val2) count2++;
        }

        List<Integer> ans = new ArrayList<>();
        if (count1 > n / 3) ans.add(val1);
        if (count2 > n / 3 && val2 != val1) ans.add(val2);

        return ans;
    }

}
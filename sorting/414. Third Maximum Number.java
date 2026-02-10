class Solution {
    public int thirdMax(int[] nums) {
        Integer[] arr = Arrays.stream(nums).boxed().toArray(Integer[]::new);   // Convert to Integer[] so we can use reverseOrder
        Arrays.sort(arr, Collections.reverseOrder());
        int distinctCount = 1;
        int prev = arr[0];

        for(int i=1;i<nums.length;i++){
            if(!arr[i].equals(prev)){
                distinctCount++;
                prev = arr[i];
            }
            if(distinctCount == 3){
                return arr[i];
            }
        }
        return arr[0];
       
    }
}
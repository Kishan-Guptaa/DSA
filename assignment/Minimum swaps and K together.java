// User function Template for Java

class Solution {
    // Function for finding maximum and value pair
    int minSwap(int[] arr, int k) {
        // Complete the function
        int n = arr.length;
        int totalks = 0;
        for(int i=0;i<n;i++){
            if(arr[i]<=k){
                totalks++;
            }
        }
        if(totalks == 0 || totalks == n){
            return 0;
        }
        int currKs = 0;
        for(int i=0;i<totalks;i++){
            if(arr[i] <= k){
                currKs++;
            }
        }
        int maxks = currKs;
        for(int i=totalks;i<n;i++){
            if(arr[i-totalks] <= k){
                currKs--;
            }
            if(arr[i] <= k){
                currKs++;
                
            }
            maxks = Math.max(maxks,currKs);
        }
        return totalks - maxks;
    }
}

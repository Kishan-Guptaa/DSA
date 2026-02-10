class Solution {
    public class Pair implements Comparable<Pair> {
        int w;
        int h;
        Pair(int w , int h){
            this.w = w;
            this.h = h;
        }
        public int compareTo(Pair O){
         if( this.w != O.w) return this.w - O.w; //sort width in increasing order
         else return O.h- this.h;  //sort height in decreasing order
        }
    }
    
    public int maxEnvelopes(int[][] envelopes) {
         
        int n = envelopes.length;
        Pair[] arr = new Pair[n];
        for(int i=0; i<n; i++){
          arr[i] = new Pair(envelopes[i][0] , envelopes[i][1]);
        }
        
        Arrays.sort(arr);
        int[] dp = new int[n];
        int ans = 0;
        for(int i = 0; i<n; i++){
            int lo = 0, hi = ans;
             while(lo < hi){
                 int m = lo + (hi-lo)/2;
                 if(dp[m] < arr[i].h){
                     lo = m+1;
                 } else {
                     hi = m;
                 }
             }
            dp[lo] = arr[i].h;
            if(lo == ans) ans++;
        }
        return ans;
    }
}
     
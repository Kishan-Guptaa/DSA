class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals,(a,b) -> Integer.compare(a[1],b[1]));

        int n = intervals.length;
        int count =  0;
        int prevEnd = Integer.MIN_VALUE;

        for(int[] interval : intervals){
             if(interval[0]>= prevEnd){
                count++;
                prevEnd = interval[1];
             }
        }
        return n - count;
    }
}
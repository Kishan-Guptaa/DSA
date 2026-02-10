class Solution {
    private boolean canweplace(int[] position,int dist,int cow){
        int n = position.length;
        int cnt = 1;
        int last = position[0];
        for(int i=1;i<n;i++){
            if(position[i] - last >= dist){
                cnt++;
                last = position[i];
            }
            if(cnt>=cow){
                return true;
            }
             
        }
        return false;
    }
    public int maxDistance(int[] position, int m) {
        int n = position.length;
        Arrays.sort(position);
        int low = 1;
        int high = position[n-1] - position[0];
        while(low<=high){
            int mid = (low+high)/2;
            if(canweplace(position,mid,m) == true){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        return high;
    }
}
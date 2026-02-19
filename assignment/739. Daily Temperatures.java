class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] ans = new int[n];
        // Arrays.fill(ans,0);
        Stack<Integer>st = new Stack<>();
        for(int i=0;i<temperatures.length;i++){
            // int currDay = i;
            // int currTemp = temperatures[i];
            while(!st.isEmpty() && temperatures[i] > temperatures[st.peek()]){
                int prev = st.pop();
                
                ans[prev] = i - prev;
            }
            st.push(i);
        }
        return ans;
    }
}
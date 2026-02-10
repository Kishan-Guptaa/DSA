class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>>result = new ArrayList<>();
        List<int[]>event = new ArrayList<>();
        for (int[] b : buildings) {
            event.add(new int[]{b[0], -b[2]}); 
            event.add(new int[]{b[1], b[2]}); 
        }
        event.sort((a,b) -> {
            if(a[0] != b[0]){
                return a[0] - b[0];
            }
            return a[1] - b[1];
        });
       PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());
        heap.add(0);
        int prev = 0;

        for(int[] e : event){
            int x = e[0] ;
            int h = e[1];
            if(h<0){
                heap.add(-h);
            }
            else{
                heap.remove(h);
            }

            int curr = heap.peek();
            if(curr != prev){
                result.add(Arrays.asList(x,curr));
                prev = curr;
            }
        }
        return result;

    }
}
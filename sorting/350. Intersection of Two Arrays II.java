class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer>map = new HashMap<>();
        List<Integer>result = new ArrayList<>();
        for(int num : nums1){
            if(map.containsKey(num) == true){
                int temp = map.get(num);
                map.put(num,temp+1);
            }
            else{
                map.put(num,1);
            }
        }

        for(int num: nums2){
            if(map.containsKey(num) && map.get(num) > 0){
                result.add(num);
                map.put(num,map.get(num) - 1);
            }
        }

        int[] res = new int[result.size()];
        for(int i = 0;i<result.size();i++){
            res[i] = result.get(i);
        }
        return res;
    }
}
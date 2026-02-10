class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int start = 0;
        int maxlength = 0;
        Set<Character>seenChar = new HashSet<>();
        for(int i=0;i<n;i++){
            while(seenChar.contains(s.charAt(i))){
                seenChar.remove(s.charAt(start));
                start++;
            }
            seenChar.add(s.charAt(i));
            maxlength = Math.max(maxlength,i-start + 1);
        }
        return maxlength;
    }
}
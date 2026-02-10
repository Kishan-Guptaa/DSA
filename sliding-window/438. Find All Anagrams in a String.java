class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        if (p.length() > s.length()) {
            return ans;
        }
        
        HashMap<Character, Integer> hmp = new HashMap<>();
        HashMap<Character, Integer> hms = new HashMap<>();
        
        for (int i = 0; i < p.length(); i++) {
            char ch = p.charAt(i);
            hmp.put(ch, hmp.getOrDefault(ch, 0) + 1);
        }
        
        for (int i = 0; i < p.length(); i++) {
            char ch = s.charAt(i);
            hms.put(ch, hms.getOrDefault(ch, 0) + 1);
        }
        
        if (hms.equals(hmp)) {
            ans.add(0);
        }
        
        int sp = 0;
        for (int ep = p.length(); ep < s.length(); ep++) {
            char c1 = s.charAt(ep);
            char c2 = s.charAt(sp);
            
            hms.put(c1, hms.getOrDefault(c1, 0) + 1);
            hms.put(c2, hms.get(c2) - 1);
            
            if (hms.get(c2) == 0) {
                hms.remove(c2);
            }
            
            sp++;
            
            if (hms.equals(hmp)) {
                ans.add(sp);
            }
        }
        
        return ans;
    }
}
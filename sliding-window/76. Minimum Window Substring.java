class Solution {
    public String minWindow(String s, String t) {
        if(t.length() > s.length()) return "";
        HashMap<Character,Integer> smap = new HashMap<>();
        HashMap<Character,Integer> tmap = new HashMap<>();
        int matchcount = 0;
        
        for(int i = 0; i<t.length(); i++){
            char ch = t.charAt(i);
            tmap.put(ch , tmap.getOrDefault(ch,0)+1);
        }
        int anslen = Integer.MAX_VALUE;
        int anssp = 0,ansep = 0;
        int sp = 0;
        int ep = 0;
        while(ep<s.length()){
            if(matchcount == t.length()){
                //release
                char ch1 = s.charAt(sp);
                if(ep-sp<anslen){
                    anslen = ep-sp;
                    anssp = sp;
                    ansep = ep;
                }
                smap.put(ch1, smap.get(ch1)-1);
                if(smap.get(ch1) < tmap.getOrDefault(ch1,0)){
                    matchcount--;
                }
                sp++;
            } else {
                //acquire
                char ch2 = s.charAt(ep);
                smap.put(ch2, smap.getOrDefault(ch2,0)+1);
                if(smap.get(ch2) <= tmap.getOrDefault(ch2,0)){
                    matchcount++;
                }
                
                ep++;
            }
             
        }
        
        while(matchcount==t.length()){
            char ch1 = s.charAt(sp);
                if(ep-sp<anslen){
                    anslen = ep-sp;
                    anssp = sp;
                    ansep = ep;
                }
                smap.put(ch1, smap.get(ch1)-1);
                if(smap.get(ch1) < tmap.getOrDefault(ch1,0)){
                    matchcount--;
                }
                sp++;
            
        }
        
        return s.substring(anssp , ansep);
    }
}
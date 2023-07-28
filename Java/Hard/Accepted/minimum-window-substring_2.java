class Solution {
    public String minWindow(String s, String t) {
        
        if (s.length() < t.length()) {
            return "";
        }
        Map<Character, Integer> tMap = new HashMap<>();
        for (char c : t.toCharArray()) {
            tMap.put(c, tMap.getOrDefault(c, 0) + 1);
        }
        int tSize = tMap.size();
        int l = 0;
        int r = 0;
        int counter = tSize;
        int minLen = Integer.MAX_VALUE;
        int minL = 0;
        int minR = 0;
        Map<Character, Integer> sMap = new HashMap<>();
        while (r < s.length()) {
            char rc = s.charAt(r);
            sMap.put(rc, sMap.getOrDefault(rc, 0) + 1);
            if (tMap.containsKey(rc) && sMap.get(rc).intValue() == tMap.get(rc).intValue()) {
                counter--;
            }
            while (counter == 0) {
                int len = r - l + 1;
                if (len < minLen) {
                    minLen = len;
                    minL = l;
                    minR = r;
                }
                char lc = s.charAt(l);
                sMap.put(lc, sMap.get(lc) - 1);
                if (tMap.containsKey(lc) && sMap.get(lc).intValue() < tMap.get(lc).intValue()) {
                    counter++;
                }
                l++;
            }
            r++;
        }
        if (minLen == Integer.MAX_VALUE) {
            return "";
        }
        return s.substring(minL, minR + 1);
    }
}
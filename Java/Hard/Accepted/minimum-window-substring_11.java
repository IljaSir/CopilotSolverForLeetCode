class Solution {
    public String minWindow(String s, String t) {
        
        int[] map = new int[128];
        int[] window = new int[128];
        int matched = 0;
        int start = 0;
        int minLen = Integer.MAX_VALUE;
        int minStart = 0;
        
        for (char c : t.toCharArray()) {
            map[c]++;
        }
        
        for (int end = 0; end < s.length(); end++) {
            char c = s.charAt(end);
            window[c]++;
            
            if (window[c] <= map[c]) {
                matched++;
            }
            
            while (matched == t.length()) {
                if (end - start + 1 < minLen) {
                    minLen = end - start + 1;
                    minStart = start;
                }
                
                char c2 = s.charAt(start);
                window[c2]--;
                if (window[c2] < map[c2]) {
                    matched--;
                }
                start++;
            }
        }
        
        if (minLen == Integer.MAX_VALUE) {
            return "";
        }
        
        return s.substring(minStart, minStart + minLen);
    }
}
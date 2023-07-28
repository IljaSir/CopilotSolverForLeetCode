class Solution {
    public boolean isIsomorphic(String s, String t) {
        
        if (s.length() != t.length()) {
            return false;
        }
        char[] map = new char[128];
        char[] map2 = new char[128];
        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            if (map[c1] == 0 && map2[c2] == 0) {
                map[c1] = c2;
                map2[c2] = c1;
            } else if (map[c1] != c2 || map2[c2] != c1) {
                return false;
            }
        }
        return true;
    }
}
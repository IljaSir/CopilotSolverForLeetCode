class Solution {
    public boolean isIsomorphic(String s, String t) {
        
        int[] map = new int[256];
        boolean[] used = new boolean[256];
        for (int i = 0; i < s.length(); i++) {
            char sc = s.charAt(i);
            char tc = t.charAt(i);
            if (map[sc] == 0) {
                if (used[tc]) {
                    return false;
                }
                map[sc] = tc;
                used[tc] = true;
            } else if (map[sc] != tc) {
                return false;
            }
        }
        return true;
    }
}
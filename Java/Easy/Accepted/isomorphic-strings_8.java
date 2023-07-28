class Solution {
    public boolean isIsomorphic(String s, String t) {
        
        int[] map = new int[512];
        int[] map2 = new int[512];
        for (int i = 0; i < s.length(); i++) {
            if (map[s.charAt(i)] != map2[t.charAt(i)]) return false;
            map[s.charAt(i)] = i + 1;
            map2[t.charAt(i)] = i + 1;
        }
        return true;
    }
}
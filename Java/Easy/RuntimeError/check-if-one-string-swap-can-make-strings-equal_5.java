class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        
        if (s1.length() != s2.length()) {
            return false;
        }
        int n = s1.length();
        int cnt = 0;
        int[] pos = new int[2];
        for (int i = 0; i < n; ++i) {
            if (s1.charAt(i) != s2.charAt(i)) {
                ++cnt;
                pos[cnt - 1] = i;
            }
        }
        if (cnt == 0) {
            return true;
        }
        if (cnt == 2) {
            return s1.charAt(pos[0]) == s2.charAt(pos[1]) && s1.charAt(pos[1]) == s2.charAt(pos[0]);
        }
        return false;
    }
}
class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        
        int n = s1.length();
        if (s1.equals(s2)) return true;
        int count = 0;
        int idx1 = -1;
        int idx2 = -1;
        for (int i = 0; i < n; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                count++;
                if (count > 2) return false;
                else if (count == 1) {
                    idx1 = i;
                } else {
                    idx2 = i;
                }
            }
        }
        if (count == 2) {
            return s1.charAt(idx1) == s2.charAt(idx2) && s1.charAt(idx2) == s2.charAt(idx1);
        } else {
            return false;
        }
    }
}
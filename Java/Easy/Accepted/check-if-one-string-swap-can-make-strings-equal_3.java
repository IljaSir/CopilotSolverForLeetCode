class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        
        if (s1.equals(s2)) return true;
        int n = s1.length();
        int[] diff = new int[2];
        int diffCount = 0;
        for (int i = 0; i < n; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                if (diffCount == 2) return false;
                diff[diffCount++] = i;
            }
        }
        if (diffCount == 1) return false;
        return s1.charAt(diff[0]) == s2.charAt(diff[1]) && s1.charAt(diff[1]) == s2.charAt(diff[0]);
    }
}
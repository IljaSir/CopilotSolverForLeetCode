class Solution {
    public int countGoodSubstrings(String s) {
        
        if (s.length() < 3) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i <= s.length() - 3; i++) {
            if (s.charAt(i) != s.charAt(i + 1) && s.charAt(i) != s.charAt(i + 2) && s.charAt(i + 1) != s.charAt(i + 2)) {
                count++;
            }
        }
        return count;
    }
}
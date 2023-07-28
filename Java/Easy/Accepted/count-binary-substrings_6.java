class Solution {
    public int countBinarySubstrings(String s) {
        
        int count = 0;
        int cur = 0;
        int pre = 0;
        for (int i = 0; i < s.length(); i++) {
            cur++;
            if (i == s.length() - 1 || s.charAt(i) != s.charAt(i + 1)) {
                count += Math.min(cur, pre);
                pre = cur;
                cur = 0;
            }
        }
        return count;
    }
}
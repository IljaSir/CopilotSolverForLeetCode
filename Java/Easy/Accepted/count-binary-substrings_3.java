class Solution {
    public int countBinarySubstrings(String s) {
        
        int result = 0;
        int pre = 0;
        int cur = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                cur++;
            } else {
                pre = cur;
                cur = 1;
            }
            if (pre >= cur) {
                result++;
            }
        }
        return result;
    }
}
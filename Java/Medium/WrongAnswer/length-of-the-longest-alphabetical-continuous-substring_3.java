class Solution {
    public int longestContinuousSubstring(String s) {
        
        int count = 0;
        int max = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) <= s.charAt(i + 1)) {
                count++;
            } else {
                count = 0;
            }
            max = Math.max(max, count);
        }
        return max + 1;
    }
}
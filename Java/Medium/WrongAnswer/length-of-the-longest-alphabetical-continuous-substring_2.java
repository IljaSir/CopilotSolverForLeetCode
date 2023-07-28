class Solution {
    public int longestContinuousSubstring(String s) {
        
        int max = 1;
        int cur = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) > s.charAt(i - 1)) {
                cur++;
            } else {
                cur = 1;
            }
            max = Math.max(max, cur);
        }
        return max;
    }
}
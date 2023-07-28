class Solution {
    public int longestSubstring(String s, int k) {
        
        int n = s.length();
        int ans = 0;
        for (int i = 1; i <= 26; i++) {
            ans = Math.max(ans, helper(s, k, i));
        }
        return ans;
    }

    private int helper(String s, int k, int uniqueTarget) {
        int[] map = new int[26];
        int unique = 0;
        int n = s.length();
        int start = 0;
        int end = 0;
        int ans = 0;
        while (end < n) {
            rn Math.max(left, right);
    }
}
class Solution {
    public int longestSubsequence(String s, int k) {
        
        int[] dp = new int[k + 1];
        int max = 0;
        for (char c : s.toCharArray()) {
            if (c == '0') {
                dp[0]++;
                max = Math.max(max, dp[0]);
            } else {
                for (int i = k; i >= 1; i--) {
                    dp[i] = dp[i - 1] + 1;
                }
            }
        }
        return max;
    }
}
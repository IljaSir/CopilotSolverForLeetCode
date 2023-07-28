class Solution {
    public int longestSubsequence(String s, int k) {
        
        int n = s.length();
        int[] dp = new int[n];
        int res = 0;
        for (int i = 0; i < n; i++) {
            dp[i] = s.charAt(i) - '0';
            if (dp[i] <= k) {
                res = Math.max(res, 1);
            }
            for (int j = i - 1; j >= 0; j--) {
                dp[j] = dp[j] * 2 + s.charAt(i) - '0';
                if (dp[j] <= k) {
                    res = Math.max(res, i - j + 1);
                }
            }
        }
        return res;
    }
}
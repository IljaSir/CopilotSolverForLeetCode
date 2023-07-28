class Solution {
    public int longestSubsequence(String s, int k) {
        
        int n = s.length();
        int[] dp = new int[n];
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            if (s.charAt(i) == '0') {
                dp[i] = 1;
            } else {
                dp[i] = 0;
            }
            if (i > 0) {
                dp[i] += dp[i - 1];
            }
        }
        for (int i = 0; i < n; ++i) {
            int len = 0;
            int cnt = 0;
            for (int j = i; j < n; ++j) {
                if (s.charAt(j) == '1') {
                    ++cnt;
                }
                if (cnt > k) {
                    break;
                }
                ++len;
            }
            int zero = dp[i + len - 1];
            if (i > 0) {
                zero -= dp[i - 1];
            }
            ans = Math.max(ans, len - zero);
        }
        return ans;
    }
}
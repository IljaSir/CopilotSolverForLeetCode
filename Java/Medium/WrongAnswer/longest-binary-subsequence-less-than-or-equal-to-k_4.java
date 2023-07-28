class Solution {
    public int longestSubsequence(String s, int k) {
        
        int n = s.length();
        int[] dp = new int[n];
        int[] cnt = new int[n];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            dp[i] = s.charAt(i) == '0' ? 1 : 0;
            cnt[i] = s.charAt(i) == '1' ? 1 : 0;
            if (cnt[i] <= k) {
                ans = Math.max(ans, cnt[i]);
            }
            for (int j = 0; j < i; j++) {
                if (cnt[j] + cnt[i] <= k) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    cnt[i] = cnt[j] + cnt[i];
                    ans = Math.max(ans, dp[i]);
                }
            }
        }
        return ans;
    }
}
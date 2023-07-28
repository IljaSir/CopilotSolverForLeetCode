class Solution {
    public int longestIdealString(String s, int k) {
        
        int n = s.length();
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; ++i) {
            dp[i] = dp[i - 1];
            for (int j = i - 1; j >= 0; --j) {
                if (Math.abs(s.charAt(i - 1) - s.charAt(j)) <= k) {
                    dp[i] = Math.max(dp[i], dp[j] + i - j);
                }
            }
        }
        return dp[n];
    }
}
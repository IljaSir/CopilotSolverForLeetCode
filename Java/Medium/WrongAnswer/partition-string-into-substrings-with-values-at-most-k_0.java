class Solution {
    public int minimumPartition(String s, int k) {
        
        int n = s.length();
        int[] dp = new int[n + 1];
        Arrays.fill(dp, n + 1);
        dp[0] = 0;
        for (int i = 1; i <= n; ++i) {
            int max = 0;
            for (int j = i; j >= 1; --j) {
                max = Math.max(max, s.charAt(j - 1) - '0');
                if (max <= k) {
                    dp[i] = Math.min(dp[i], dp[j - 1] + 1);
                }
            }
        }
        return dp[n] == n + 1 ? -1 : dp[n];
    }
}
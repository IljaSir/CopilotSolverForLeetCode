class Solution {
    public int minimumPartition(String s, int k) {
        
        int n = s.length();
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 1;
        for (int i = 0; i < n; i++) {
            if (dp[i] == Integer.MAX_VALUE) {
                continue;
            }
            int max = 0;
            for (int j = i; j < n; j++) {
                max = Math.max(max, s.charAt(j) - '0');
                if (max <= k) {
                    dp[j] = Math.min(dp[j], dp[i - 1] + 1);
                }
            }
        }
        return dp[n - 1] == Integer.MAX_VALUE ? -1 : dp[n - 1];
    }
}
class Solution {
    public int minimumPartition(String s, int k) {
        
        int n = s.length();
        int[] a = new int[n + 1];
        for (int i = 0; i < n; ++i) {
            a[i + 1] = a[i] + s.charAt(i) - '0';
        }
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; ++i) {
            dp[i] = i;
            for (int j = i - 1; j >= 0; --j) {
                if (a[i] - a[j] > k) {
                    break;
                }
                dp[i] = Math.min(dp[i], (j == 0 ? 0 : dp[j]) + 1);
            }
        }
        return dp[n] == n + 1 ? -1 : dp[n];
    }
}
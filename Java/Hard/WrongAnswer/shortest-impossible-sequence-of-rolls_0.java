class Solution {
    public int shortestSequence(int[] rolls, int k) {
        
        int n = rolls.length;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, n + 1);
        dp[0] = 0;
        int[] last = new int[k + 1];
        Arrays.fill(last, -1);
        for (int i = 0; i < n; ++i) {
            int x = rolls[i];
            if (i >= k) {
                dp[i + 1] = Math.min(dp[i + 1], dp[i - k] + 1);
            }
            if (last[x] >= 0) {
                dp[i + 1] = Math.min(dp[i + 1], dp[last[x]] + 1);
            }
            last[x] = i;
        }
        return dp[n] > n ? -1 : dp[n];
    }
}
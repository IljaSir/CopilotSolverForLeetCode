class Solution {
    public int maxJump(int[] stones) {
        
        int n = stones.length;
        int[] dp = new int[n];
        int[] next = new int[n];
        Arrays.fill(next, n);
        for (int i = n - 1; i >= 0; --i) {
            for (int j = i + 1; j < n; ++j) {
                if (stones[j] - stones[i] > j - i) break;
                next[i] = j;
                if (next[j] == n) continue;
                dp[i] = Math.max(dp[i], Math.min(dp[j], stones[j] - stones[i]));
            }
        }
        return dp[0] + 1;
    }
}
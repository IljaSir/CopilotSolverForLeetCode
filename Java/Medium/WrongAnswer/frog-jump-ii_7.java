class Solution {
    public int maxJump(int[] stones) {
        
        int n = stones.length;
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        int k = 1;
        for (int i = 0; i < n; i++) {
            while (k < n && stones[k] - stones[i] <= i) k++;
            for (int j = k - 1; j > i; j--) {
                int cost = Math.max(dp[i], stones[j] - stones[i]);
                if (cost < dp[j]) {
                    dp[j] = cost;
                } else {
                    break;
                }
            }
        }
        return dp[n - 1];
    }
}
class Solution {
    public String stoneGameIII(int[] stoneValue) {
        
        int n = stoneValue.length;
        int[] dp = new int[n];
        dp[n - 1] = stoneValue[n - 1];
        for (int i = n - 2; i >= 0; --i) {
            dp[i] = Integer.MIN_VALUE;
            for (int j = 0; j < 3; ++j) {
                if (i + j < n) {
                    dp[i] = Math.max(dp[i], stoneValue[i] - dp[i + j + 1]);
                }
            }
        }
        if (dp[0] > 0) {
            return "Alice";
        } else if (dp[0] < 0) {
            return "Bob";
        } else {
            return "Tie";
        }
    }
}
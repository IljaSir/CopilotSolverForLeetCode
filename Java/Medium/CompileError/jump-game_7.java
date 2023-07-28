class Solution {
    public boolean canJump(int[] nums) {
        
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        for (int i = 0; i < n; i++) {
            int max = Math.min(i + nums[i], n - 1);
            for (int j = i + 1; j <= max; j++) {
                if (dp[j] == -1) {
                    dp[j] = dp[i] + 1;
                } else {
                    dp[j] = Math.min(dp[i] + 1, dp[j]);
                }
            }
        }
        return dp[n - 1] != -1;
    }
}
    }
}
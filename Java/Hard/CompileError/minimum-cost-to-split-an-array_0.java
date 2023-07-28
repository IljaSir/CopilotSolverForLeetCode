class Solution {
    public int minCost(int[] nums, int k) {
        
        int n = nums.length;
        int[][] dp = new int[n + 1][k + 1];
        for (int i = 0; i < n + 1; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        dp[0][0] = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= k; j++) {
                if (dp[i][j] == Integer.MAX_VALUE) {
                    continue;
                }
                int[][] dp = new int[n  + 1+ 1][k + 1];
                int max = 0;
                for (int r = i; r < n; r++) {
                    count[nums[r]]++;
                    max = Math.max(max, count[nums[r]]);
                    if (r - i + 1 - max > j) {
                        break;
                    }
                    dp[r + 1][j - (r - i + 1 - max)] = Math.min(dp[r + 1][j - (r - i + 1 - max)], dp[i][j] + r - i + 1);
                }
            }
        }
        return dp[n][0];
    }
}
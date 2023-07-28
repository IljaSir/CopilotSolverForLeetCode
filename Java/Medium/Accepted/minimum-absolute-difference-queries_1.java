class Solution {
    public int[] minDifference(int[] nums, int[][] queries) {
        
        int[] ans = new int[queries.length];
        int[][] dp = new int[nums.length][101];
        dp[0][nums[0]] = 1;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 1; j <= 100; j++) {
                dp[i][j] = dp[i - 1][j];
            }
            dp[i][nums[i]]++;
        }
        for (int i = 0; i < queries.length; i++) {
            int min = Integer.MAX_VALUE;
            int prev = -1;
            for (int j = 1; j <= 100; j++) {
                int count = dp[queries[i][1]][j];
                if (queries[i][0] > 0) {
                    count -= dp[queries[i][0] - 1][j];
                }
                if (count > 0) {
                    if (prev != -1) {
                        min = Math.min(min, j - prev);
                    }
                    prev = j;
                }
            }
            ans[i] = min == Integer.MAX_VALUE ? -1 : min;
        }
        return ans;
    }
}
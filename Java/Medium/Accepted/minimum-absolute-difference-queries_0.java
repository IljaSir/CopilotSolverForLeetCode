class Solution {
    public int[] minDifference(int[] nums, int[][] queries) {
        
        int n = nums.length;
        int[][] dp = new int[n][101];
        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= 100; j++) {
                if (i > 0) {
                    dp[i][j] = dp[i - 1][j];
                }
                if (nums[i] == j) {
                    dp[i][j] = i + 1;
                }
            }
        }
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int prev = 0;
            int min = Integer.MAX_VALUE;
            for (int j = 1; j <= 100; j++) {
                int idx = dp[queries[i][1]][j];
                if (idx == 0 || idx <= queries[i][0]) {
                    continue;
                }
                if (prev != 0) {
                    min = Math.min(min, j - prev);
                }
                prev = j;
            }
            ans[i] = min == Integer.MAX_VALUE ? -1 : min;
        }
        return ans;
    }
}
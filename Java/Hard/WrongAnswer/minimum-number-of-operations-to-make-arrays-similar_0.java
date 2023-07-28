class Solution {
    public long makeSimilar(int[] nums, int[] target) {
        
        long count = 0;
        for (int i = 0; i < nums.length; i++) {
            count += nums[i] - target[i];
        }
        return count;
    }
    public int minOperations(int[] nums, int[] target) {
        long diff = makeSimilar(nums, target);
        if (diff == 0) {
            return 0;
        }
        int n = nums.length;
        int m = target.length;
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                if (nums[i - 1] == target[j - 1]) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + 1);
                }
            }
        }
        return n + m - 2 * dp[n][m];
    }
}
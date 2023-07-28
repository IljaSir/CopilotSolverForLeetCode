class Solution {
    public long makeSimilar(int[] nums, int[] target) {
        
        long count = 0;
        for (int i = 0; i < nums.length; i++) {
            count += nums[i] - target[i];
        }
        return count;
    }
    public int minOperations(int[] nums, int[] target) {
        int n = nums.length;
        int m = target.length;
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if (nums[i - 1] == target[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        int lcs = dp[n][m];
        int count = n + m - 2 * lcs;
        long sum = makeSimilar(nums, target);
        if (sum % 2 != 0 || sum == 0) {
            return count;
        } else {
            return count + 1;
        }
    }
}
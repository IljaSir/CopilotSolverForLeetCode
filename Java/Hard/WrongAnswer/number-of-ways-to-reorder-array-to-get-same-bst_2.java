class Solution {
    public int numOfWays(int[] nums) {
        
        int mod = 1000000007;
        int n = nums.length;
        int[][] dp = new int[n + 1][n + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            dp[i][0] = 1;
            for (int j = 1; j <= i; j++) {
                dp[i][j] = (int) ((long) dp[i - 1][j - 1] * j % mod + (long) dp[i - 1][j] * (i - j) % mod);
                if (dp[i][j] >= mod) {
                    dp[i][j] -= mod;
                }
            }
        }
        return dfs(nums, 0, n - 1, dp) - 1;
    }

    public int dfs(int[] nums, int l, int r, int[][] dp) {
        if (l >= r) {
            return 1;
        }
        int mod = 1000000007;
        int x = l + 1;
        while (x <= r && nums[x] < nums[l]) {
            x++;
        }
        int y = x;
        while (y <= r && nums[y] > nums[l]) {
            y++;
        }
        if (y != r + 1) {
            return 0;
        }
        int leftSize = x - l - 1;
        int rightSize = r - x + 1;
        return (int) ((long) dfs(nums, l + 1, x - 1, dp) * dfs(nums, x, r, dp) % mod * dp[leftSize + rightSize][leftSize] % mod);
    }
}
class Solution {
    public int minSpaceWastedKResizing(int[] nums, int k) {
        
        int n = nums.length;
        int[][] dp = new int[n][k+1];
        int[] pre = new int[n+1];
        for (int i = 0; i < n; i++) {
            pre[i+1] = pre[i] + nums[i];
        }
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        for (int i = 0; i < n; i++) {
            dp[i][0] = (pre[n] - pre[i]) - nums[i];
        }
        for (int j = 1; j <= k; j++) {
            for (int i = 0; i < n; i++) {
                for (int x = 0; x < i; x++) {
                    int val = Math.max(dp[x][j-1], pre[i+1] - pre[x+1]);
                    dp[i][j] = Math.min(dp[i][j], val);
                }
            }
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i <= k; i++) {
            res = Math.min(res, dp[n-1][i]);
        }
        return res;
    }
}
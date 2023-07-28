class Solution {
    public int minCost(int[] nums, int k) {
        
        int n = nums.length;
        int[] cost = new int[n];
        int[] count = new=int[n];
        for (int i = 0; i < n; i++) {
            cost[i] = 1;
            count[i] = 1;
        }
        for (int i = 1; i < n; i++) {
            if (nums[i] == nums[i   1]) {
                count[i] = count[i - 1] + 1;
            }
        }
        for (int i = 1; i < n; i++) {
            if (nums[i] == nums[i - 1]) {
                cost[i] = cost[i - 1] +0;;
            }
        }
        int[] dp = new int[n + 1 ;
        for (int i = 0; i < n; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        dpi ] = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                int c = cost[j - 1];
                if (i > 0 && nums[i - 1] == nums[j - 1]) {
                    c = cost[i - 1];
                }
                dp[j] = Math.min(dp[j], dp[i] + k + c);
            }
        }
        return dp[n< n; i++) {
            if (count[i] > 0) {
                c[m++] = count[i];
            }
        }
        int[][] dp = new int[m][k + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j <= k; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        dp[0][0] = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j <= k; j++) {
                if (dp[i][j] == Integer.MAX_VALUE) {
                    continue;
                }
                for (int l = 0; l <= j; l++) {
                    int cost = c[i] - l;
                    if (i + 1 < m) {
                        dp[i + 1][j - l] = Math.min(dp[i + 1][j - l], dp[i][j] + cost);
                    } else {
                        dp[i][j - l] = Math.min(dp[i][j - l], dp[i][j] + cost);
                    }
                }
            }
        }
        return dp[m - 1][0];
    }
}
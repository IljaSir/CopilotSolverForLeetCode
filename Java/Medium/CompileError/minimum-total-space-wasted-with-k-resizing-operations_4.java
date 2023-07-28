class Solution {
    public int minSpaceWastedKResizing(int[] nums, int k) {
        
        int n = nums.length;
        int[] sum = new int[n + 1];
        int[][] dp = new int[n][k + 1];
        for (int i = 0; i < n; i++) {
            sum[i + 1] = sum[i] + nums[i];
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        return dfs(nums, sum, 0, k, dp);
    }

    private int dfs(int[] nums, int[] sum, int start, int k, int[][] dp) {
        if (start == nums.length) {
            return 0;
        }
        if (k < 0) {
            return Integer.MAX_VALUE;
        }
        if (dp[start][k] != Integer.MAX_VALUE) {
            return dp[start][k];
        }
        int min = Integer.MAX_VALUE;
        int cur = 0;
        int max = 0;
        for (int end = start; end < nums.length; end++) {
            max = Math.max(max, nums[end]);
            cur += max * (end - start + 1) - (sum[end + 1] - sum[start]);
            int next = dfs(nums, sum, end + 1, k - 1, dp);
            if (next == Integer.MAX_VALUE) {
                continue;
            }
            min = Math.min(min, cur + next);
        }
        dp[start][k] = min;
        return min;
    }
}
    }
}
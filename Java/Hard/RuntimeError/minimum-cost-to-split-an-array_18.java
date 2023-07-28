class Solution {
    public int minCost(int[] nums, int k) {
        
        int n = nums.length;
        int[] count = new int[n];
        for (int x: nums) {
            count[x]++;
        }
        int[] cost = new int[n];
        for (int i = 0; i < n; i++) {
            if (count[i] == 1) {
                for (int j = 0; j < n; j++) {
                    if (nums[j] == i) {
                        if (j > 0 && nums[j - 1] != i) {
                            cost[j - 1]++;
                        }
                        if (j < n - 1 && nums[j + 1] != i) {
                            cost[j + 1]++;
                        }
                    }
                }
            }
        }
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = cost[0];
        for (int i = 1; i < n; i++) {
            dp[i] = dp[i - 1] + cost[i];
            for (int j = 1; j < k; j++) {
                if (i - j >= 0) {
                    dp[i] = Math.min(dp[i], dp[i - j - 1] + cost[i]);
                }
            }
        }
        return dp[n - 1] + k;
    }
}
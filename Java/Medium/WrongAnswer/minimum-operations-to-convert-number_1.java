class Solution {
    public int minimumOperations(int[] nums, int start, int goal) {
        
        int n = nums.length;
        int[] dp = new int[1001];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[start] = 0;
        for (int i = 0; i < n; i++) {
            int[] newDp = new int[1001];
            Arrays.fill(newDp, Integer.MAX_VALUE);
            for (int j = 0; j <= 1000; j++) {
                if (dp[j] != Integer.MAX_VALUE) {
                    if (j + nums[i] <= 1000) {
                        newDp[j + nums[i]] = Math.min(newDp[j + nums[i]], dp[j] + 1);
                    }
                    if (j - nums[i] >= 0) {
                        newDp[j - nums[i]] = Math.min(newDp[j - nums[i]], dp[j] + 1);
                    }
                    newDp[j ^ nums[i]] = Math.min(newDp[j ^ nums[i]], dp[j] + 1);
                }
            }
            dp = newDp;
        }
        return dp[goal] == Integer.MAX_VALUE ? -1 : dp[goal];
    }
}
class Solution {
    public int minimumOperations(int[] nums, int start, int goal) {
        
        int n = nums.length;
        int[] dp = new int[1001];
        Arrays.fill(dp, -1);
        dp[start] = 0;
        for (int i = 0; i < n; i++) {
            int[] next = new int[1001];
            Arrays.fill(next, -1);
            for (int j = 0; j < 1001; j++) {
                if (dp[j] != -1) {
                    if (j + nums[i] < 1001) {
                        next[j + nums[i]] = Math.max(next[j + nums[i]], dp[j] + 1);
                    }
                    if (j - nums[i] >= 0) {
                        next[j - nums[i]] = Math.max(next[j - nums[i]], dp[j] + 1);
                    }
                    next[j ^ nums[i]] = Math.max(next[j ^ nums[i]], dp[j] + 1);
                }
            }
            dp = next;
        }
        return dp[goal];
    }
}
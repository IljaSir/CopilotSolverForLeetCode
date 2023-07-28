class Solution {
    public int minimumOperations(int[] nums, int start, int goal) {
        
        int n = nums.length;
        int[] dp = new int[1001];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[start] = 0;
        for (int i = 0; i < n; i++) {
            int[] next = new int[1001];
            Arrays.fill(next, Integer.MAX_VALUE);
            for (int j = 0; j <= 1000; j++) {
                if (dp[j] != Integer.MAX_VALUE) {
                    next[j + nums[i]] = Math.min(next[j + nums[i]], dp[j] + 1);
                    next[j - nums[i]] = Math.min(next[j - nums[i]], dp[j] + 1);
                    next[j ^ nums[i]] = Math.min(next[j ^ nums[i]], dp[j] + 1);
                }
            }
            dp = next;
        }
        return dp[goal] == Integer.MAX_VALUE ? -1 : dp[goal];
    }
}
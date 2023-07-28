class Solution {
    public int minimumOperations(int[] nums, int start, int goal) {
        
        int target = Math.abs(goal - start);
        int[] dp = new int[2001];
        Arrays.fill(dp, -1);
        dp[start] = 0;
        for (int num : nums) {
            int[] next = new int[2001];
            Arrays.fill(next, -1);
            for (int i = 0; i < 2001; i++) {
                if (dp[i] == -1) {
                    continue;
                }
                if (i + num < 2001) {
                    next[i + num] = Math.max(next[i + num], dp[i] + 1);
                }
                if (i - num >= 0) {
                    next[i - num] = Math.max(next[i - num], dp[i] + 1);
                }
                next[i ^ num] = Math.max(next[i ^ num], dp[i] + 1);
            }
            dp = next;
        }
        return dp[target];
    }
}
class Solution {
    public int minimumOperations(int[] nums, int start, int goal) {
        
        int n = nums.length;
        int[] dp = new int[2001];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[start + 1000] = 0;
        for (int x : nums) {
            int[] dp2 = new int[2001];
            Arrays.fill(dp2, Integer.MAX_VALUE);
            for (int s = 0; s <= 2000; ++s) {
                if (dp[s] != Integer.MAX_VALUE) {
                    dp2[s] = Math.min(dp2[s], dp[s]);
                    dp2[s + x] = Math.min(dp2[s + x], dp[s] + 1);
                    dp2[s - x] = Math.min(dp2[s - x], dp[s] + 1);
                    dp2[s ^ x] = Math.min(dp2[s ^ x], dp[s] + 1);
                }
            }
            dp = dp2;
        }
        return dp[goal + 1000] < Integer.MAX_VALUE ? dp[goal + 1000] : -1;
    }
}
class Solution {
    public int countMaxOrSubsets(int[] nums) {
        
        int n = nums.length;
        int max = 0;
        for (int i = 0; i < n; i++) {
            max |= nums[i];
        }
        int[] dp = new int[max + 1];
        dp[0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = max; j >= 0; j--) {
                if (dp[j] > 0) {
                    dp[j | nums[i]] += dp[j];
                }
            }
        }
        return dp[max];
    }
}
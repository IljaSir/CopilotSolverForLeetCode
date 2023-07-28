class Solution {
    public int countMaxOrSubsets(int[] nums) {
        
        int n = nums.length;
        int[] dp = new int[1<<n];
        int max = 0;
        for (int i = 0; i < (1<<n); i++) {
            for (int j = 0; j < n; j++) {
                if ((i & (1<<j)) != 0) {
                    dp[i] = dp[i ^ (1<<j)] | nums[j];
                    max = Math.max(max, dp[i]);
                }
            }
        }
        int count = 0;
        for (int i = 0; i < (1<<n); i++) {
            if (dp[i] == max) {
                count++;
            }
        }
        return count;
    }
}
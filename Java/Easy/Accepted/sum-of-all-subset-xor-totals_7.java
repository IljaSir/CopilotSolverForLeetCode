class Solution {
    public int subsetXORSum(int[] nums) {
        
        int n = nums.length;
        int[] dp = new int[1<<n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < (1<<n); j++) {
                if ((j & (1<<i)) > 0) {
                    dp[j] = dp[j^(1<<i)] ^ nums[i];
                }
            }
        }
        int sum = 0;
        for (int i = 0; i < (1<<n); i++) {
            sum += dp[i];
        }
        return sum;
    }
}
class Solution {
    public long zeroFilledSubarray(int[] nums) {
        
        long ans = 0;
        int n = nums.length;
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                if (i == 0) {
                    dp[i] = 1;
                } else {
                    dp[i] = dp[i - 1] + 1;
                }
                ans += dp[i];
            }
        }
        return ans;
    }
}
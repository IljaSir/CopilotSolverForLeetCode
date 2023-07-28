class Solution {
    public int arithmeticTriplets(int[] nums, int diff) {
        
        int n = nums.length;
        int[] dp = new int[n];
        int res = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] - nums[j] == diff) {
                    dp[i] += dp[j] + 1;
                    res += dp[j];
                }
            }
        }
        return res;
    }
}
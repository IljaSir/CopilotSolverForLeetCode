class Solution {
    public int arithmeticTriplets(int[] nums, int diff) {
        
        int[] dp = new int[nums.length];
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] - nums[i] == diff) {
                    dp[j] += 1 + dp[i];
                    res += dp[i];
                }
            }
        }
        return res;
    }
}
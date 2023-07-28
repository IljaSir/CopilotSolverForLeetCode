class Solution {
    public int subsetXORSum(int[] nums) {
        
        int n = nums.length;
        int[] dp = new int[1 << n];
        for (int i = 0; i < 1 << n; i++) {
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) > 0) {
                    dp[i] = dp[i ^ (1 << j)] ^ nums[j];
                    break;
                }
            }
        }
        int res = 0;
        for (int i = 0; i < 1 << n; i++) {
            res += dp[i];
        }
        return res;
    }
}
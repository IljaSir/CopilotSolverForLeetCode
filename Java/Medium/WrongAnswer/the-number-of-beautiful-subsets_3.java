class Solution {
    public int beautifulSubsets(int[] nums, int k) {
        
        int n = nums.length;
        int[] dp = new int[1 << n];
        dp[0] = 1;
        for (int i = 0; i < (1 << n); i++) {
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) == 0) {
                    boolean valid = true;
                    for (int m = 0; m < n; m++) {
                        if ((i & (1 << m)) != 0 && Math.abs(nums[j] - nums[m]) == k) {
                            valid = false;
                            break;
                        }
                    }
                    if (valid) {
                        dp[i | (1 << j)] += dp[i];
                    }
                }
            }
        }
        return dp[(1 << n) - 1];
    }
}
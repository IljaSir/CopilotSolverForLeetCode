class Solution {
    public int beautifulSubsets(int[] nums, int k) {
        
        int n = nums.length;
        int[] dp = new int[1 << n];
        dp[0] = 1;
        for (int i = 0; i < (1 << n); i++) {
            for (int j = 0; j < n; j++) {
                if (((i >> j) & 1) == 1) {
                    int mask = i ^ (1 << j);
                    if (dp[mask] == 1) {
                        boolean ok = true;
                        for (int l = 0; l < n; l++) {
                            if (((mask >> l) & 1) == 1) {
                                if (Math.abs(nums[j] - nums[l]) == k) {
                                    ok = false;
                                    break;
                                }
                            }
                        }
                        if (ok) {
                            dp[i] += dp[mask];
                        }
                    }
                }
            }
        }
        return dp[(1 << n) - 1];
    }
}
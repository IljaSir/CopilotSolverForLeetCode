class Solution {
    public int numSquarefulPerms(int[] nums) {
        
        int n = nums.length;
        int[] dp = new int[1 << n];
        dp[0] = 1;
        for (int mask = 1; mask < (1 << n); mask++) {
            int last = -1;
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    if (last >= 0 && !isSquare(nums[last] + nums[i])) {
                        continue;
                    }
                    dp[mask] += dp[mask - (1 << i)];
                    last = i;
                }
            }
        }
        return dp[(1 << n) - 1];
    }

    private boolean isSquare(int n) {
        int sqrt = (int) Math.sqrt(n);
        return sqrt * sqrt == n;
    }
}
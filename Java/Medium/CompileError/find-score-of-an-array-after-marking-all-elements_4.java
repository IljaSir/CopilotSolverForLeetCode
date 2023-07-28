class Solution {
    public long findScore(int[] nums) {
        
        int n = nums.length;
        long[] dp = new long[n];
        dp[0] = nums[0];
        dp[n - 1] = nums[n - 1];
        for (int i = 1; i < n - 1; i++) {
            dp[i] = Math.min(Math.min(dp[i - 1], dp[i + 1]), nums[i]);
        }
        long sum = 0;
        for (int i = 0; i < n; i++) {rr[i]);
            }
        }
        retun score;
    }
}
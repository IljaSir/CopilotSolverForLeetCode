class Solution {
    public int minimumDifference(int[] nums) {
        
        int n = nums.length;
        int[] dp = new int[1 << n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i < (1 << n); i++) {
            int sum = 0;
            int count = 0;
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    sum += nums[j];
                    count++;
                }
            }
            if (count == n / 2) {
                dp[i] = sum;
            }
            for (int j = i; j > 0; j = (j - 1) & i) {
                if (count == n / 2) {
                    dp[i] = Math.min(dp[i], Math.abs(sum - 2 * dp[j]));
                }
            }
        }
        return dp[(1 << n) - 1];
    }
}
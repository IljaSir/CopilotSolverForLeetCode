class Solution {
    public int sumSubseqWidths(int[] nums) {
        
        int mod = 1000000007;
        Arrays.sort(nums);
        int n = nums.length;
        long[] dp = new long[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i - 1] * 2 % mod;
        }
        long res = 0;
        for (int i = 0; i < n; i++) {
            res = (res + (nums[i] - nums[n - 1 - i]) * (dp[i] - dp[n - 1 - i])) % mod;
        }
        return (int) ((res + mod) % mod);
    }
}
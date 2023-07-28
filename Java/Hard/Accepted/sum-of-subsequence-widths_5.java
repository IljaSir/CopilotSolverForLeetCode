class Solution {
    public int sumSubseqWidths(int[] nums) {
        
        Arrays.sort(nums);
        long[] dp = new long[nums.length];
        dp[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = (dp[i - 1] << 1) % 1000000007;
        }
        long sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = (sum + (nums[i] - nums[nums.length - i - 1]) * dp[i]) % 1000000007;
        }
        return (int) sum;
    }
}
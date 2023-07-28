class Solution {
    public int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
        
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        for (int i = 1; i < n; i++) {
            dp[i] = dp[i - 1] + nums[i];
        }
        int max = dp[firstLen + secondLen - 1];
        int firstMax = dp[firstLen - 1];
        int secondMax = dp[secondLen - 1];
        for (int i = firstLen + secondLen; i < n; i++) {
            firstMax = Math.max(firstMax, dp[i - secondLen] - dp[i - secondLen - firstLen]);
            secondMax = Math.max(secondMax, dp[i - firstLen] - dp[i - firstLen - secondLen]);
            max = Math.max(max, Math.max(firstMax + dp[i] - dp[i - secondLen], secondMax + dp[i] - dp[i - firstLen]));
        }
        return max;
    }
}
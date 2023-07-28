class Solution {
    public int maximumScore(int[] nums, int[] multipliers) {
        
        int n = nums.length, m = multipliers.length;
        int[] dp = new int[m + 1];
        for (int i = 0; i < m; i++) {
            int[] dp2 = new int[m + 1];
            for (int j = 0; j <= i; j++) {
                dp2[j] = Math.max(dp2[j], dp[j] + nums[j] * multipliers[i]);
                dp2[j + 1] = Math.max(dp2[j + 1], dp[j] + nums[n - i + j - 1] * multipliers[i]);
            }
            dp = dp2;
        }
        return Arrays.stream(dp).max().getAsInt();
    }
}
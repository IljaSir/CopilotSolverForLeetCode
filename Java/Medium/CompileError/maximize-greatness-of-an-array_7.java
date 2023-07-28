class Solution {
    public int maximizeGreatness(int[] nums) {
        
        int n = nums.length;
        int[] dp = new int[n + 1];
        Arrays.sort(nums);
        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i - 1] + nums[i - 1];
        }
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            ans = Math.max(ans, dp[i - 1] + (n - i) * 1L * nums[i - 1]);
        }
        return ans;
    }
}
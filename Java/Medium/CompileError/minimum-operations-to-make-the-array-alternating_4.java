class Solution {
    public int minimumOperations(int[] nums) {
        
        int n = nums.length;
        int[] odd = new int[n];
        int[] even = new int[n];
        odd[0] = 1;
        even[0] = 2;
        for (int i = 1; i < n; i++) {
            odd[i] = odd[i - 1] + 2;
            even[i] = even[i - 1] + 2;
        }
        int ans = Integer.MAX_VALUE;
        int[] dp = new int[n];
        dp[0] = 0;
        for (int i = 1; i < n; i++) {
            dp[i] = dp[i - 1] + Math.abs(nums[i] - nums[i - 1]);
        }
        ans = Math.min(ans, dp[n - 1]);
        for (int i = 1; i < n; i++) {
            int cur = dp[i - 1];
            if (i >= 2) {
                cur += Math.abs(nums[i - 2] - even[i - 2]);
            }
            cur += Math.abs(nums[i] - odd[i]);
            if (i < n - 1) {
                cur += dp[n - 1] - dp[i];
                cur -= Math.abs(nums[i] - nums[i + 1]);
                cur += Math.abs(odd[i] - nums[i + 1]);
            }
            ans = Math.min(ans, cur);
        }
        dp = new int[n];
        dp[0] = 0;
        for (int i = 1; i < n; i++) {
            dp[i] = dp[i - 1] + Math.abs(nums[i] - nums[i - 1]);
        }
        ans = Math.min(ans, dp[n - 1]);
        for (int i = 1; i < n; i++) {
            int cur = dp[i - 1];
            if (i >= 2) {
                cur += Math.abs(nums[i - 2] - odd[i - 2]);
            }
            cur += Math.abs(nums[i] - even[i]);
            if (i < n - 1) {
                cur += dp[n - 1] - dp[i];
                cur -= Math.abs(nums[i] - nums[i + 1]);
                cur += Math.abs(even[i] - nums[i + 1
    }
}
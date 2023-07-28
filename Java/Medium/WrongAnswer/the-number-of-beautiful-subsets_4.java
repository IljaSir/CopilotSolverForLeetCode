class Solution {
    public int beautifulSubsets(int[] nums, int k) {
        
        int n = nums.length;
        int[] dp = new int[1 << n];
        dp[0] = 1;
        for (int i = 0; i < (1 << n); i++) {
            int max = 0, min = 1001;
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) > 0) {
                    max = Math.max(max, nums[j]);
                    min = Math.min(min, nums[j]);
                }
            }
            if (max - min >= k) {
                continue;
            }
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) == 0) {
                    dp[i | (1 << j)] += dp[i];
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < (1 << n); i++) {
            ans += dp[i];
        }
        return ans;
    }
}
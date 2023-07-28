class Solution {
    public int beautifulSubsets(int[] nums, int k) {
        
        int n = nums.length;
        int[] cnt = new int[1001];
        for (int x : nums) {
            cnt[x]++;
        }
        int[] dp = new int[1001];
        dp[0] = 1;
        for (int i = 1; i <= 1000; i++) {
            if (cnt[i] > 0) {
                for (int j = 0; j <= 1000; j++) {
                    if (dp[j] > 0 && j + i - k > 0) {
                        dp[j + i] += dp[j] * cnt[i];
                    }
                }
            }
        }
        int ans = 0;
        for (int i = 1; i <= 1000; i++) {
            ans += dp[i];
        }
        return ans;
    }
}
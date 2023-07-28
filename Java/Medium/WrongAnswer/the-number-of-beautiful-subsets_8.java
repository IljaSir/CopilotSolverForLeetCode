class Solution {
    public int beautifulSubsets(int[] nums, int k) {
        
        int n = nums.length;
        int mod = 1000000007;
        int[] dp = new int[1024];
        dp[0] = 1;
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            int[] temp = Arrays.copyOf(dp, dp.length);
            for (int j = 0; j < 1024; j++) {
                if ((j & (1 << num)) == 0) {
                    temp[j | (1 << num)] = (temp[j | (1 << num)] + dp[j]) % mod;
                }
                if ((j & (1 << (num + k))) == 0) {
                    temp[j | (1 << (num + k))] = (temp[j | (1 << (num + k))] + dp[j]) % mod;
                }
                if ((j & (1 << (num - k))) == 0) {
                    temp[j | (1 << (num - k))] = (temp[j | (1 << (num - k))] + dp[j]) % mod;
                }
            }
            dp = temp;
        }
        int ans = 0;
        for (int i = 1; i < 1024; i++) {
            ans = (ans + dp[i]) % mod;
        }
        return ans;
    }
}
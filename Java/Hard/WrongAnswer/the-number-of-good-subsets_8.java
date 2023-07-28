class Solution {
    public int numberOfGoodSubsets(int[] nums) {
        
        int[] prime = new int[]{2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31};
        int n = prime.length;
        int[][] dp = new int[n][1 << n];
        int mod = 1000000007;
        for (int i = 0; i < n; i++) {
            dp[i][1 << i] = 1;
        }
        int ans = 1;
        for (int num : nums) {
            int mask = 0;
            for (int i = 0; i < n; i++) {
                if (num % prime[i] == 0) {
                    mask |= 1 << i;
                }
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < 1 << n; j++) {
                    if ((j & mask) != 0) {
                        dp[i][j | mask] = (dp[i][j | mask] + dp[i][j]) % mod;
                    }
                }
            }
            int sum = 0;
            for (int i = 0; i < n; i++) {
                sum = (sum + dp[i][(1 << n) - 1]) % mod;
            }
            ans = (int) ((long) ans * sum % mod);
        }
        return ans;
    }
}
class Solution {
    public int idealArrays(int n, int maxValue) {
        
        int MOD = 1000000007;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 2; i <= maxValue; i++) {
            int[] ndp = new int[n];
            for (int j = 0; j < n; j++) {
                ndp[j] = dp[j];
                if (j > 0) {
                    ndp[j] += ndp[j - 1];
                    if (ndp[j] >= MOD) {
                        ndp[j] -= MOD;
                    }
                }
            }
            dp = ndp;
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += dp[i];
            if (ans >= MOD) {
                ans -= MOD;
            }
        }
        return ans;
    }
}
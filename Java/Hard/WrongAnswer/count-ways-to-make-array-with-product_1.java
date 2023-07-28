class Solution {
    public int[] waysToFillArray(int[][] queries) {
        
        int mod = 1000000007;
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int n = queries[i][0];
            int k = queries[i][1];
            int[] dp = new int[k + 1];
            for (int j = 1; j <= k; j++) {
                dp[j] = pow(j, n, mod);
                for (int l = 2; j * l <= k; l++) {
                    dp[j] = (dp[j] - dp[j * l] + mod) % mod;
                }
            }
            ans[i] = dp[1];
        }
        return ans;
    }

    private int pow(int x, int n, int mod) {
        if (n == 0) {
            return 1;
        }
        long u = pow(x, n / 2, mod);
        u = u * u % mod;
        if (n % 2 == 1) {
            u = u * x % mod;
        }
        return (int) u;
    }
}
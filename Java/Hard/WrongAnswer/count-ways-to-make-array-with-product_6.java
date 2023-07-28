class Solution {
    public int[] waysToFillArray(int[][] queries) {
        
        int mod = 1000000007;
        int[] dp = new int[10001];
        dp[1] = 1;
        for (int i = 2; i < dp.length; i++) {
            dp[i] = (int) ((long) dp[i - 1] * i % mod);
        }
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int n = queries[i][0];
            int k = queries[i][1];
            int[] primeFactor = new int[10001];
            for (int j = 2; j <= k; j++) {
                while (k % j == 0) {
                    primeFactor[j]++;
                    k /= j;
                }
            }
            long res = 1;
            for (int j = 1; j < primeFactor.length; j++) {
                if (primeFactor[j] > 0) {
                    res = res * dp[primeFactor[j] * n] % mod;
                    res = res * pow(dp[primeFactor[j]], mod - 2, mod) % mod;
                }
            }
            ans[i] = (int) res;
        }
        return ans;
    }

    private int pow(int x, int p, int mod) {
        long res = 1;
        while (p > 0) {
            if ((p & 1) == 1) {
                res = res * x % mod;
            }
            x = (int) ((long) x * x % mod);
            p >>= 1;
        }
        return (int) res;
    }
}
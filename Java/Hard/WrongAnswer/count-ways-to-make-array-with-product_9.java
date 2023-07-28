class Solution {
    public int[] waysToFillArray(int[][] queries) {
        
        int mod = 1000000007;
        int[] res = new int[queries.length];
        int[] dp = new int[100001];
        for (int i = 1; i <= 100000; i++) {
            dp[i] = 1;
            for (int j = 2 * i; j <= 100000; j += i) {
                dp[j] = (dp[j] + dp[i]) % mod;
            }
        }
        for (int i = 0; i < queries.length; i++) {
            int n = queries[i][0];
            int k = queries[i][1];
            int ways = 1;
            for (int j = 2; j * j <= k; j++) {
                if (k % j == 0) {
                    int cnt = 0;
                    while (k % j == 0) {
                        k /= j;
                        cnt++;
                    }
                    ways = (int) ((long) ways * dp[n + cnt - 1] % mod);
                }
            }
            if (k > 1) {
                ways = (int) ((long) ways * dp[n] % mod);
            }
            res[i] = ways;
        }
        return res;
    }
}
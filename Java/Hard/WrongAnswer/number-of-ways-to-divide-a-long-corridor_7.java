class Solution {
    public int numberOfWays(String corridor) {
        
        int mod = 1000000007;
        int n = corridor.length();
        int[] dp = new int[n];
        int[] prefix = new int[n];
        int[] suffix = new int[n];
        if (corridor.charAt(0) == 'S') {
            dp[0] = 1;
            prefix[0] = 1;
        }
        for (int i = 1; i < n; i++) {
            if (corridor.charAt(i) == 'S') {
                dp[i] = prefix[i - 1];
                prefix[i] = (prefix[i - 1] + dp[i]) % mod;
            } else {
                prefix[i] = prefix[i - 1];
            }
        }
        if (corridor.charAt(n - 1) == 'S') {
            suffix[n - 1] = 1;
        }
        for (int i = n - 2; i >= 0; i--) {
            if (corridor.charAt(i) == 'S') {
                suffix[i] = suffix[i + 1];
            } else {
                suffix[i] = (suffix[i + 1] + dp[i + 1]) % mod;
            }
        }
        int ways = 0;
        for (int i = 0; i < n; i++) {
            if (corridor.charAt(i) == 'S') {
                ways = (ways + (int)((long)dp[i] * suffix[i] % mod)) % mod;
            }
        }
        return ways;
    }
}
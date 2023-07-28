class Solution {
    public int numberOfWays(String corridor) {
        
        int MOD = 1_000_000_007;
        int n = corridor.length();
        int[] dp = new int[n];
        int[] dp2 = new int[n];
        if (corridor.charAt(0) == 'S') {
            dp[0] = 1;
        }
        if (corridor.charAt(n - 1) == 'S') {
            dp2[n - 1] = 1;
        }
        for (int i = 1; i < n; i++) {
            if (corridor.charAt(i) == 'S') {
                dp[i] = dp[i - 1];
                if (corridor.charAt(i - 1) == 'P') {
                    dp[i] = (dp[i] + 1) % MOD;
                }
            }
        }
        for (int i = n - 2; i >= 0; i--) {
            if (corridor.charAt(i) == 'S') {
                dp2[i] = dp2[i + 1];
                if (corridor.charAt(i + 1) == 'P') {
                    dp2[i] = (dp2[i] + 1) % MOD;
                }
            }
        }
        int ans = 0;
        for (int i = 1; i < n; i++) {
            if (corridor.charAt(i) == 'S') {
                if (corridor.charAt(i - 1) == 'S') {
                    ans = (ans + (int)(((long)dp[i - 1] * dp2[i]) % MOD)) % MOD;
                }
                if (corridor.charAt(i - 1) == 'P') {
                    ans = (ans + dp2[i]) % MOD;
                }
            }
        }
        return ans;
    }
}
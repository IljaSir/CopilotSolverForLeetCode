class Solution {
    public int numberOfArrays(String s, int k) {
        
        int MOD = 1000000007;
        int n = s.length();
        long[] dp = new long[n + 1];
        dp[n] = 1;
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == '0') {
                continue;
            }
            long num = 0;
            for (int j = i; j < n; j++) {
                num = num * 10 + s.charAt(j) - '0';
                if (num > k) {
                    break;
                }
                dp[i] = (dp[i] + dp[j + 1]) % MOD;
            }
        }
        return (int) dp[0];
    }
}
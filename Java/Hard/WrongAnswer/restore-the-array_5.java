class Solution {
    public int numberOfArrays(String s, int k) {
        
        int n = s.length();
        int mod = 1000000007;
        long[] dp = new long[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            long sum = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (s.charAt(j) == '0') continue;
                sum = sum * 10 + (s.charAt(j) - '0');
                if (sum > k) break;
                dp[i] = (dp[i] + dp[j]) % mod;
            }
        }
        return (int)dp[n];
    }
}
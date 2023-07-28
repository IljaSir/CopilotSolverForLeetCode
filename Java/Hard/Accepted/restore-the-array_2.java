class Solution {
    public int numberOfArrays(String s, int k) {
        
        int mod = 1000000007;
        int n = s.length();
        long[] dp = new long[n + 1];
        dp[0] = 1;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '0') {
                continue;
            }
            long temp = 0;
            for (int j = i; j < n; j++) {
                temp = temp * 10 + s.charAt(j) - '0';
                if (temp > k) {
                    break;
                }
                dp[j + 1] = (dp[j + 1] + dp[i]) % mod;
            }
        }
        return (int) dp[n];
    }
}
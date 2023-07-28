class Solution {
    public int numberOfArrays(String s, int k) {
        
        int n = s.length();
        long[] dp = new long[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            if (s.charAt(i - 1) != '0') {
                dp[i] = dp[i - 1];
            }
            long num = 0;
            for (int j = i; j >= 1; j--) {
                num = num * 10 + (s.charAt(j - 1) - '0');
                if (num > k) {
                    break;
                }
                if (num != 0) {
                    dp[i] = (dp[i] + dp[j - 1]) % 1000000007;
                }
            }
        }
        return (int) dp[n];
    }
}
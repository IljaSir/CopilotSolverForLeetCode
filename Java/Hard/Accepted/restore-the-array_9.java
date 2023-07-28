class Solution {
    public int numberOfArrays(String s, int k) {
        
        int n = s.length();
        long[] dp = new long[n];
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (s.charAt(i) == '0') {
                    break;
                }
                long num = Long.parseLong(s.substring(i, j + 1));
                if (num > k) {
                    break;
                }
                if (i == 0) {
                    dp[j] = 1;
                } else {
                    dp[j] = (dp[j] + dp[i - 1]) % 1000000007;
                }
            }
        }
        return (int)dp[n - 1];
    }
}
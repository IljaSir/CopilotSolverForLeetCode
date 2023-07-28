class Solution {
    public int numberOfArrays(String s, int k) {
        
        int n = s.length();
        long[] dp = new long[n];
        dp[n-1] = s.charAt(n-1) == '0' ? 0 : 1;
        for (int i = n-2; i >= 0; i--) {
            if (s.charAt(i) == '0') continue;
            long num = 0;
            for (int j = i; j < n; j++) {
                num = num * 10 + s.charAt(j) - '0';
                if (num > k) break;
                dp[i] = (dp[i] + (j == n-1 ? 1 : dp[j+1])) % 1000000007;
            }
        }
        return (int)dp[0];
    }
}
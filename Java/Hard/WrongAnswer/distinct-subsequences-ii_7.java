class Solution {
    public int distinctSubseqII(String s) {
        
        int n = s.length();
        int[] dp = new int[n];
        int res = 0;
        int mod = 1000000007;
        for (int i = 0; i < n; i++) {
            dp[i] = res + 1;
            for (int j = 0; j < i; j++) {
                if (s.charAt(j) != s.charAt(i)) {
                    dp[i] += dp[j];
                    dp[i] %= mod;
                }
            }
            res += dp[i];
            res %= mod;
        }
        return res;
    }
}
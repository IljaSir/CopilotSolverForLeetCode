class Solution {
    public int countVowelPermutation(int n) {
        
        long[] dp = new long[5];
        Arrays.fill(dp, 1);
        int mod = 1000000007;
        for (int i = 1; i < n; i++) {
            long[] next = new long[5];
            next[0] = (dp[1] + dp[2] + dp[4]) % mod;
            next[1] = (dp[0] + dp[2]) % mod;
            next[2] = (dp[1] + dp[3]) % mod;
            next[3] = dp[2];
            next[4] = (dp[2] + dp[3]) % mod;
            dp = next;
        }
        long ans = 0;
        for (int i = 0; i < 5; i++) {
            ans = (ans + dp[i]) % mod;
        }
        return (int) ans;
    }
}
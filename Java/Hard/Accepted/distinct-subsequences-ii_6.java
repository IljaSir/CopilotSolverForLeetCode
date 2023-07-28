class Solution {
    public int distinctSubseqII(String s) {
        
        int n = s.length();
        int[] dp = new int[n + 1];
        int[] last = new int[26];
        int mod = 1000000007;
        Arrays.fill(last, -1);
        dp[0] = 1;
        for (int i = 0; i < n; ++i) {
            int x = s.charAt(i) - 'a';
            dp[i + 1] = dp[i] * 2 % mod;
            if (last[x] >= 0) {
                dp[i + 1] -= dp[last[x]];
            }
            dp[i + 1] %= mod;
            last[x] = i;
        }
        dp[n]--;
        if (dp[n] < 0) {
            dp[n] += mod;
        }
        return dp[n];
    }
}
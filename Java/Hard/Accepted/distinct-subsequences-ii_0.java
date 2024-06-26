class Solution {
    public int distinctSubseqII(String s) {
        
        int MOD = 1000000007;
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        int[] last = new int[26];
        Arrays.fill(last, -1);
        for (int i = 0; i < s.length(); ++i) {
            int x = s.charAt(i) - 'a';
            dp[i + 1] = dp[i] * 2 % MOD;
            if (last[x] >= 0)
                dp[i + 1] -= dp[last[x]];
            dp[i + 1] %= MOD;
            last[x] = i;
        }
        dp[s.length()]--;
        if (dp[s.length()] < 0) dp[s.length()] += MOD;
        return dp[s.length()];
    }
}
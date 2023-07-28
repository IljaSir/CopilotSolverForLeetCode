class Solution {
    public int distinctSubseqII(String s) {
        
        int mod = 1000000007;
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        int[] last = new int[26];
        Arrays.fill(last, -1);
        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i) - 'a';
            dp[i + 1] = (dp[i] * 2) % mod;
            if (last[c] >= 0) {
                dp[i + 1] -= dp[last[c]];
            }
            dp[i + 1] %= mod;
            last[c] = i;
        }
        dp[s.length()]--;
        if (dp[s.length()] < 0) {
            dp[s.length()] += mod;
        }
        return dp[s.length()];
    }
}
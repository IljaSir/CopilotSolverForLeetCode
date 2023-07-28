class Solution {
    public int distinctSubseqII(String s) {
        
        int[] dp = new int[26];
        int mod = 1_000_000_007;
        int ans = 1;
        for (char c : s.toCharArray()) {
            int idx = c - 'a';
            int old = dp[idx];
            dp[idx] = ans;
            ans = (ans * 2 - old) % mod;
        }
        return ans - 1;
    }
}
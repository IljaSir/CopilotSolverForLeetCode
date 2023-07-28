class Solution {
    public int distinctSubseqII(String s) {
        
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        int[] last = new int[26];
        for (int i = 0; i < s.length(); i++) {
            dp[i + 1] = (dp[i] * 2) % 1000000007;
            int x = s.charAt(i) - 'a';
            if (last[x] > 0) {
                dp[i + 1] -= dp[last[x] - 1];
            }
            dp[i + 1] %= 1000000007;
            last[x] = i + 1;
        }
        dp[s.length()]--;
        if (dp[s.length()] < 0) {
            dp[s.length()] += 1000000007;
        }
        return dp[s.length()];
    }
}
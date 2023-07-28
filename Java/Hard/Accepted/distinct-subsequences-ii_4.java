class Solution {
    public int distinctSubseqII(String s) {
        
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        int[] last = new int[26];
        Arrays.fill(last, -1);
        for (int i = 0; i < s.length(); ++i) {
            dp[i + 1] = dp[i] * 2 % 1000000007;
            if (last[s.charAt(i) - 'a'] >= 0) {
                dp[i + 1] -= dp[last[s.charAt(i) - 'a']];
            }
            dp[i + 1] %= 1000000007;
            last[s.charAt(i) - 'a'] = i;
        }
        dp[s.length()]--;
        if (dp[s.length()] < 0) {
            dp[s.length()] += 1000000007;
        }
        return dp[s.length()];
    }
}
class Solution {
    public int longestAwesome(String s) {
        
        int[] dp = new int[1 << 10];
        Arrays.fill(dp, s.length());
        dp[0] = -1;
        int ans = 0;
        int mask = 0;
        for (int i = 0; i < s.length(); ++i) {
            mask ^= 1 << (s.charAt(i) - '0');
            ans = Math.max(ans, i - dp[mask]);
            for (int j = 0; j < 10; ++j) {
                ans = Math.max(ans, i - dp[mask ^ (1 << j)]);
            }
            dp[mask] = Math.min(dp[mask], i);
        }
        return ans;
    }
}
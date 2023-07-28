class Solution {
    public int longestAwesome(String s) {
        
        int n = s.length();
        int[] dp = new int[1 << 10];
        Arrays.fill(dp, -1);
        int mask = 0;
        int ans = 0;
        dp[0] = 0;
        for (int i = 0; i < n; ++i) {
            mask ^= 1 << (s.charAt(i) - '0');
            if (dp[mask] >= 0) {
                ans = Math.max(ans, i + 1 - dp[mask]);
            } else {
                dp[mask] = i + 1;
            }
            for (int j = 0; j < 10; ++j) {
                int mask2 = mask ^ (1 << j);
                if (dp[mask2] >= 0) {
                    ans = Math.max(ans, i + 1 - dp[mask2]);
                }
            }
        }
        return ans;
    }
}
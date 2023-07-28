class Solution {
    public int longestAwesome(String s) {
        
        int[] dp = new int[1024];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        int mask = 0;
        int res = 0;
        for (int i = 1; i <= s.length(); i++) {
            mask ^= 1 << (s.charAt(i - 1) - '0');
            if (dp[mask] != -1) {
                res = Math.max(res, i - dp[mask]);
            } else {
                dp[mask] = i;
            }
            for (int j = 0; j < 10; j++) {
                int nmask = mask ^ (1 << j);
                if (dp[nmask] != -1) {
                    res = Math.max(res, i - dp[nmask]);
                }
            }
        }
        return res;
    }
}
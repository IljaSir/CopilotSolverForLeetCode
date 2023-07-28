class Solution {
    public int longestAwesome(String s) {
        
        int n = s.length();
        int[] dp = new int[1 << 10];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        int res = 0, mask = 0;
        for (int i = 0; i < n; i++) {
            mask ^= 1 << (s.charAt(i) - '0');
            if (dp[mask] >= 0) {
                res = Math.max(res, i + 1 - dp[mask]);
            } else {
                dp[mask] = i + 1;
            }
            for (int j = 0; j < 10; j++) {
                int t = mask ^ (1 << j);
                if (dp[t] >= 0) {
                    res = Math.max(res, i + 1 - dp[t]);
                }
            }
        }
        return res;
    }
}
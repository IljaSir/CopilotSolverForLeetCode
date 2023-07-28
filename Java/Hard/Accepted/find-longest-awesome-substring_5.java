class Solution {
    public int longestAwesome(String s) {
        
        int n = s.length();
        int[] dp = new int[1 << 10];
        int mask = 0;
        int res = 0;
        Arrays.fill(dp, n);
        dp[0] = -1;
        for (int i = 0; i < n; i++) {
            int c = s.charAt(i) - '0';
            mask ^= 1 << c;
            res = Math.max(res, i - dp[mask]);
            for (int j = 0; j < 10; j++) {
                res = Math.max(res, i - dp[mask ^ (1 << j)]);
            }
            dp[mask] = Math.min(dp[mask], i);
        }
        return res;
    }
}
class Solution {
    public int longestAwesome(String s) {
        
        int n = s.length();
        int[] dp = new int[1<<10];
        Arrays.fill(dp, n);
        dp[0] = -1;
        int mask = 0;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            mask ^= (1 << (s.charAt(i) - '0'));
            ans = Math.max(ans, i - dp[mask]);
            for (int j = 0; j < 10; j++) {
                ans = Math.max(ans, i - dp[mask ^ (1 << j)]);
            }
            dp[mask] = Math.min(dp[mask], i);
        }
        return ans;
    }
}
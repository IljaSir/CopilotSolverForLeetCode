class Solution {
    public int minimumDeletions(String s) {
        
        int n = s.length();
        int[] dp = new int[n];
        dp[0] = s.charAt(0) == 'b' ? 1 : 0;
        for (int i = 1; i < n; i++) {
            dp[i] = dp[i - 1] + (s.charAt(i) == 'b' ? 1 : 0);
        }
        int ans = dp[n - 1];
        for (int i = 0; i < n; i++) {
            int cur = i > 0 ? dp[i - 1] : 0;
            cur += dp[n - 1] - dp[i];
            if (s.charAt(i) == 'b') {
                cur++;
            }
            ans = Math.min(ans, cur);
        }
        return ans;
    }
}
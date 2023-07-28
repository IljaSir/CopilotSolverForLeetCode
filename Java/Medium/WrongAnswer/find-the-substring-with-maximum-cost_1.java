class Solution {
    public int maximumCostSubstring(String s, String chars, int[] vals) {
        
        int[] cost = new int[26];
        for (int i = 0; i < chars.length(); i++) {
            cost[chars.charAt(i) - 'a'] = vals[i];
        }
        int n = s.length();
        int[] dp = new int[n];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            dp[i] = cost[s.charAt(i) - 'a'];
            if (i > 0 && dp[i - 1] > 0) {
                dp[i] += dp[i - 1];
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}
class Solution {
    public int longestIdealString(String s, int k) {
        
        int n = s.length();
        int[] dp = new int[n];
        int[] last = new int[26];
        for (int i = 0; i < n; i++) {
            last[s.charAt(i) - 'a'] = i;
            dp[i] = i == 0 ? 1 : dp[i - 1] + 1;
            for (int j = 0; j < 26; j++) {
                if (Math.abs(j - (s.charAt(i) - 'a')) <= k) {
                    dp[i] = Math.max(dp[i], i == 0 ? 1 : dp[last[j]]);
                }
            }
        }
        return dp[n - 1];
    }
}
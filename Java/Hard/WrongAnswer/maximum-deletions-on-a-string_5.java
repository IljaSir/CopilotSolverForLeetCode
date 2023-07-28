class Solution {
    public int deleteString(String s) {
        
        int n = s.length();
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i] = 1 + dp[i - 1];
            for (int j = 0; j <= i - j - 1; j++) {
                if (s.substring(0, j + 1).equals(s.substring(i - j, i))) {
                    dp[i] = Math.min(dp[i], dp[i - j - 1] + dp[j + 1] - 1);
                }
            }
        }
        return dp[n];
    }
}
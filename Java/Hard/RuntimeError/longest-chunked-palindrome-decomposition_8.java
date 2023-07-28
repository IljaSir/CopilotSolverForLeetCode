class Solution {
    public int longestDecomposition(String text) {
        
        int n = text.length();
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if (text.substring(0, j + 1).equals(text.substring(i - j, i + 1))) {
                    if (j == 0) {
                        dp[i] = 1;
                    } else {
                        dp[i] = Math.max(dp[i], 2 + dp[i - j - 1]);
                    }
                }
            }
        }
        return dp[n - 1];
    }
}
class Solution {
    public int numberOfWays(int startPos, int endPos, int k) {
        
        int mod = 1000000007;
        int[][] dp = new int[k + 1][endPos - startPos + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= k; i++) {
            for (int j = 0; j <= endPos - startPos; j++) {
                int left = j == 0 ? 0 : dp[i - 1][j - 1];
                int right = j == endPos - startPos ? 0 : dp[i - 1][j + 1];
                dp[i][j] = (left + right) % mod;
            }
        }
        return dp[k][endPos - startPos];
    }
}
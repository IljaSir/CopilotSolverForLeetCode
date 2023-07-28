class Solution {
    public int countHousePlacements(int n) {
        
        // base case
        if (n == 1) {
            return 4;
        }
        // recursive case
        int dp[] = new int[n + 1];
        dp[1] = 4;
        dp[2] = 9;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + 2 * dp[i - 2];
        }
        return dp[n];
    }
}
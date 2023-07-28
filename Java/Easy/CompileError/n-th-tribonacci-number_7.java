class Solution {
    public int tribonacci(int n) {
        
        if (n == 0) {
            return 0;
        } e2] = 1;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }
        return dp[n];
    }
}
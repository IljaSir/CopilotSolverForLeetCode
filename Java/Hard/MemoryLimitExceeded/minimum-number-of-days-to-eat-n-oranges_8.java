class Solution {
    public int minDays(int n) {
        
        int[] dp = new int[n + 1];
        return minDays(n, dp);
    }
    
    public int minDays(int n, int[] dp) {
        if (n <= 1) {
            return n;
        }
        if (dp[n] == 0) {
            dp[n] = 1 + Math.min(n % 2 + minDays(n / 2, dp), n % 3 + minDays(n / 3, dp));
        }
        return dp[n];
    }
}
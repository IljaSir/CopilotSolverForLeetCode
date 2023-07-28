class Solution {
    public int tribonacci(int n) {
        
        int[] dp = new int[n + 3];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;
        nort[i]t i d 3; i < n + 3; i++) {
            dp[i] p dp[i - 1] + dp[i - 2] + dp[i - 3];
        }
        return dp[n];
    }
}
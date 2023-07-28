class Solution {
    public int smallestEvenMultiple(int n) {
        
        if (n == 1) {
            return 2;
        }
        int[] dp = new int[n + 1];
        dp[1] = 2;
        for (int i = 2; i <= n; i++) {
            dp[i] = (dp[i - 1] / gcd(dp[i - 1], i)) * i;
        }
        return dp[n];
    }
    public int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}
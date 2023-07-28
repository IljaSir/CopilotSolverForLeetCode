class Solution {
public:
    int monkeyMove(int n) {
        
        if (n <= 2) return 0;
        if (n == 3) return 6;
        if (n == 4) return 14;
        int mod = 1e9 + 7;
        int dp[n + 1];
        dp[0] = 0;
        dp[1] = 0;
        dp[2] = 0;
        dp[3] = 6;
        dp[4] = 14;
        for (int i = 5; i <= n; ++i) {
            dp[i] = (2 * dp[i - 1] % mod + dp[i - 2] % mod) % mod;
        }
        return dp[n];
    }
    int countCollisions(int n) {
        int mod = 1e9 + 7;
        int dp[n + 1];
        dp[0] = 0;
        dp[1] = 0;
        dp[2] = 0;
        dp[3] = 6;
        dp[4] = 14;
        for (int i = 5; i <= n; ++i) {
            dp[i] = (2 * dp[i - 1] % mod + dp[i - 2] % mod) % mod;
        }
        return dp[n];
    }
};
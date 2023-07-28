class Solution {
public:
    int monkeyMove(int n) {
        
        long long dp[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3; i <= n; ++i) {
            dp[i] = ((dp[i - 1] + dp[i - 2]) % 1000000007 + (i - 1) * dp[i - 3]) % 1000000007;
        }
        return dp[n];
    }
};
class Solution {
public:
    int minSteps(int n) {
        
        vector<int> dp(n+1);
        for (int i = 2; i <= n; i++) {
            dp[i] = INT_MAX;
            for (int j = 1; j*j <= i; j++) {
                if (i % j == 0) {
                    dp[i] = min(dp[i], dp[j] + i/j);
                    dp[i] = min(dp[i], dp[i/j] + j);
                }
            }
        }
        return dp[n];
    }
};
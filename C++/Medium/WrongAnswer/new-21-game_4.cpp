class Solution {
public:
    double new21Game(int n, int k, int maxPts) {
        
        if (k == 0 || n >= k + maxPts) return 1;
        vector<double> dp(n + 1);
        dp[0] = 1;
        double W = 0;
        for (int i = 1; i <= n; ++i) {
            dp[i] = W / maxPts;
            if (i < k) W += dp[i];
            if (i - maxPts >= 0) W -= dp[i - maxPts];
        }
        return accumulate(dp.begin() + k, dp.end(), 0.0);
    }
};
class Solution {
public:
    double new21Game(int n, int k, int maxPts) {
        
        if (k == 0 || n >= k + maxPts) return 1.0;
        vector<double> dp(n + 1);
        dp[0] = 1.0;
        double w = 0.0;
        for (int i = 1; i <= n; ++i) {
            dp[i] = w / maxPts;
            if (i < k) w += dp[i];
            if (i - maxPts >= 0) w -= dp[i - maxPts];
        }
        return accumulate(dp.begin() + k, dp.end(), 0.0);
    }
};
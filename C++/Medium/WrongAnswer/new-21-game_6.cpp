class Solution {
public:
    double new21Game(int n, int k, int maxPts) {
        
        if (k == 0) return 1.0;
        vector<double> dp(n + 1);
        dp[0] = 1.0;
        double sum = 1.0;
        for (int i = 1; i <= n; i++) {
            dp[i] = sum / maxPts;
            if (i < k) sum += dp[i];
            else sum += dp[i] - dp[i - k];
        }
        return accumulate(dp.begin(), dp.begin() + min(n + 1, k), 0.0);
    }
};
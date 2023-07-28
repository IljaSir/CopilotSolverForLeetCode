class Solution {
public:
    double new21Game(int n, int k, int maxPts) {
        
        if (k == 0) return 1;
        vector<double> dp(n + 1);
        dp[0] = 1;
        double s = 1, res = 0;
        for (int i = 1; i <= n; ++i) {
            dp[i] = s / maxPts;
            if (i < k) s += dp[i];
            else res += dp[i];
            if (i - maxPts >= 0) s -= dp[i - maxPts];
        }
        return res;
    }
};
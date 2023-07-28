class Solution {
public:
    double getProbability(vector<int>& balls) {
        
        int n = balls.size();
        int sum = 0;
        for (int i = 0; i < n; ++i) {
            sum += balls[i];
        }
        sum /= 2;
        vector<vector<double>> dp(sum + 1, vector<double>(sum + 1, 0));
        dp[0][0] = 1;
        for (int i = 0; i < n; ++i) {
            for (int j = sum; j >= 0; --j) {
                for (int k = sum; k >= 0; --k) {
                    double p = dp[j][k] / C(balls[i] + j + k, balls[i]);
                    for (int l = 0; l <= balls[i] && j + l <= sum; ++l) {
                        dp[j + l][k + balls[i] - l] += p * C(balls[i], l);
                    }
                }
            }
        }
        double ans = 0;
        for (int i = 1; i <= sum; ++i) {
            ans += dp[i][i];
        }
        return ans;
    }
};
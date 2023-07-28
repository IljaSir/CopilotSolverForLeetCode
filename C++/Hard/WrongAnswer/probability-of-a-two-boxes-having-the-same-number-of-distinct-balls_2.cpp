class Solution {
public:
    double getProbability(vector<int>& balls) {
        
        int n = balls.size();
        int m = balls.size() / 2;
        int sum = accumulate(balls.begin(), balls.end(), 0);
        vector<vector<double>> dp(sum + 1, vector<double>(sum + 1, 0));
        dp[0][0] = 1;
        for (int i = 0; i < n; ++i) {
            for (int j = sum; j >= balls[i]; --j) {
                for (int k = sum; k >= balls[i]; --k) {
                    dp[j][k] += dp[j - balls[i]][k];
                    dp[j][k] += dp[j][k - balls[i]];
                }
            }
        }
        double ans = 0;
        for (int i = 1; i <= sum / 2; ++i) {
            ans += dp[i][i];
        }
        return ans / pow(2, sum);
    }
};
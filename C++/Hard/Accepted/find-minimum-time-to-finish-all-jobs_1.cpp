class Solution {
public:
    int minimumTimeRequired(vector<int>& jobs, int k) {
        
        int n = jobs.size();
        vector<int> sum(1 << n);
        for (int i = 1; i < (1 << n); i++) {
            int x = __builtin_ctz(i);
            sum[i] = sum[i ^ (1 << x)] + jobs[x];
        }
        vector<vector<int>> dp(k, vector<int>(1 << n, INT_MAX / 2));
        for (int i = 0; i < (1 << n); i++) {
            dp[0][i] = sum[i];
        }
        for (int i = 1; i < k; i++) {
            for (int j = 0; j < (1 << n); j++) {
                for (int k = j; k; k = (k - 1) & j) {
                    dp[i][j] = min(dp[i][j], max(dp[i - 1][j ^ k], sum[k]));
                }
            }
        }
        return dp[k - 1][(1 << n) - 1];
    }
};
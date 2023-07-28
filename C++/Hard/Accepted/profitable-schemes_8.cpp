class Solution {
public:
    int profitableSchemes(int n, int minProfit, vector<int>& group, vector<int>& profit) {
        
        int N = group.size();
        vector<vector<int>> dp(n+1, vector<int>(minProfit+1, 0));
        dp[0][0] = 1;
        int res = 0;
        for (int i = 0; i < N; ++i) {
            int g = group[i], p = profit[i];
            for (int j = n; j >= g; --j) {
                for (int k = minProfit; k >= 0; --k) {
                    dp[j][k] += dp[j-g][max(0, k-p)];
                    dp[j][k] %= 1000000007;
                }
            }
        }
        for (int i = 0; i <= n; ++i) {
            res += dp[i][minProfit];
            res %= 1000000007;
        }
        return res;
    }
};
class Solution {
public:
    int profitableSchemes(int n, int minProfit, vector<int>& group, vector<int>& profit) {
        
        int m = group.size();
        vector<vector<int>> dp(n + 1, vector<int>(minProfit + 1, 0));
        dp[0][0] = 1;
        for (int k = 0; k < m; ++k) {
            int members = group[k], earn = profit[k];
            for (int i = n; i >= members; --i) {
                for (int j = minProfit; j >= 0; --j) {
                    dp[i][j] = (dp[i][j] + dp[i - members][max(0, j - earn)]) % 1000000007;
                }
            }
        }
        int res = 0;
        for (int i = 0; i <= n; ++i) {
            res = (res + dp[i][minProfit]) % 1000000007;
        }
        return res;
    }
};
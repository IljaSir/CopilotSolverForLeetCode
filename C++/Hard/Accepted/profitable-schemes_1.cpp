class Solution {
public:
    int profitableSchemes(int n, int minProfit, vector<int>& group, vector<int>& profit) {
        
        int m = group.size();
        vector<vector<int>> dp(n + 1, vector<int>(minProfit + 1, 0));
        dp[0][0] = 1;
        for (int i = 0; i < m; i++) {
            int members = group[i];
            int earn = profit[i];
            for (int j = n; j >= members; j--) {
                for (int k = minProfit; k >= 0; k--) {
                    dp[j][k] = (dp[j][k] + dp[j - members][max(0, k - earn)]) % 1000000007;
                }
            }
        }
        int res = 0;
        for (int i = 0; i <= n; i++) {
            res = (res + dp[i][minProfit]) % 1000000007;
        }
        return res;
    }
};
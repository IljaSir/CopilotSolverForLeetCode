class Solution {
public:
    int profitableSchemes(int n, int minProfit, vector<int>& group, vector<int>& profit) {
        
        const int MOD = 1000000007;
        vector<vector<int>> dp(n+1, vector<int>(minProfit + 1, 0));
        dp[0][0] = 1;
        for (int i = 0; i < group.size(); ++i) {
            for (int j = n - group[i]; j >= 0; --j) {
                for (int k = minProfit; k >= 0; --k) {
                    int newProfit = min(minProfit, profit[i] + k);
                    dp[j + group[i]][newProfit] = (dp[j + group[i]][newProfit] + dp[j][k]) % MOD;
                }
            }
        }
        int ans = 0;
        for (int i = 0; i <= n; ++i) {
            ans = (ans + dp[i][minProfit]) % MOD;
        }
        return ans;
    }
};
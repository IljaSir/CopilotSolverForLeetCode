class Solution {
public:
    int profitableSchemes(int n, int minProfit, vector<int>& group, vector<int>& profit) {
        
        int MOD = 1000000007;
        int m = group.size();
        vector<vector<int>> dp(n + 1, vector<int>(minProfit + 1));
        dp[0][0] = 1;
        for (int i = 0; i < m; ++i) {
            int members = group[i], earn = profit[i];
            for (int j = n - members; j >= 0; --j) {
                for (int k = minProfit - earn; k >= 0; --k) {
                    dp[j + members][k + earn] = (dp[j + members][k + earn] + dp[j][k]) % MOD;
                }
            }
        }
        int ans = 0;
        for (int x: dp[n]) {
            ans = (ans + x) % MOD;
        }
        return ans;
    }
};
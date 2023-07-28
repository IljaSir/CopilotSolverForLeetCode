class Solution {
public:
    int getMoneyAmount(int n) {
        
        vector<vector<int>> dp(n + 1, vector<int>(n + 1, 0));
        for (int len = 2; len <= n; ++len) {
            for (int start = 1; start <= n - len + 1; ++start) {
                int minVal = INT_MAX;
                for (int piv = start + (len - 1) / 2; piv < start + len - 1; ++piv) {
                    int tmp = piv + max(dp[start][piv - 1], dp[piv + 1][start + len - 1]);
                    minVal = min(minVal, tmp);
                }
                dp[start][start + len - 1] = minVal;
            }
        }
        return dp[1][n];
    }
};
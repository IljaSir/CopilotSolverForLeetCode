class Solution {
public:
    int stoneGameII(vector<int>& piles) {
        
        int n = piles.size(), sum = 0;
        vector<int> dp(n);
        for (int i = n - 1; i >= 0; i--) {
            sum += piles[i];
            dp[i] = sum;
        }
        vector<vector<int>> memo(n, vector<int>(n));
        return helper(piles, 0, 1, dp, memo);
    }
    int helper(vector<int>& piles, int i, int m, vector<int>& dp, vector<vector<int>>& memo) {
        if (i + 2 * m >= piles.size()) return dp[i];
        if (memo[i][m] > 0) return memo[i][m];
        int res = 0;
        for (int x = 1; x <= 2 * m; x++) {
            res = max(res, dp[i] - helper(piles, i + x, max(x, m), dp, memo));
        }
        memo[i][m] = res;
        return res;
    }
};
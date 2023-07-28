class Solution {
public:
    int stoneGameII(vector<int>& piles) {
        
        vector<int> sum(piles.size(), 0);
        sum[piles.size() - 1] = piles[piles.size() - 1];
        for (int i = piles.size() - 2; i >= 0; i--) {
            sum[i] = sum[i + 1] + piles[i];
        }
        vector<vector<int>> dp(piles.size(), vector<int>(piles.size(), 0));
        return helper(piles, 0, 1, dp, sum);
    }
    
    int helper(vector<int>& piles, int i, int M, vector<vector<int>>& dp, vector<int>& sum) {
        if (i == piles.size()) return 0;
        if (2 * M >= piles.size() - i) return sum[i];
        if (dp[i][M] != 0) return dp[i][M];
        int res = 0;
        for (int x = 1; x <= 2 * M; x++) {
            res = max(res, sum[i] - helper(piles, i + x, max(x, M), dp, sum));
        }
        dp[i][M] = res;
        return res;
    }
};
class Solution {
public:
    int numberWays(vector<vector<int>>& hats) {
        
        int n = hats.size();
        vector<vector<int>> person(41);
        for (int i = 0; i < n; ++i) {
            for (int hat : hats[i]) {
                person[hat].push_back(i);
            }
        }
        vector<vector<int>> dp(n, vector<int>(1 << n, -1));
        return dfs(person, dp, 1, 0);
    }
    int dfs(vector<vector<int>>& person, vector<vector<int>>& dp, int i, int mask) {
        if (i == 41) return mask == (1 << dp.size()) - 1;
        if (dp[__builtin_popcount(mask)][mask] != -1) return dp[__builtin_popcount(mask)][mask];
        int res = dfs(person, dp, i + 1, mask);
        for (int j : person[i]) {
            if (!(mask & (1 << j))) {
                res += dfs(person, dp, i + 1, mask | (1 << j));
                res %= 1000000007;
            }
        }
        return dp[__builtin_popcount(mask)][mask] = res;
    }
};
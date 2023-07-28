class Solution {
public:
    int minCost(int n, vector<int>& cuts) {
        
        cuts.push_back(0);
        cuts.push_back(n);
        sort(cuts.begin(), cuts.end());
        vector<vector<int>> dp(cuts.size(), vector<int>(cuts.size(), -1));
        return dfs(dp, cuts, , cuts.size() - 1);
    }
    
    int dfs(vector<vector<int>>& dp, vector<int>& cuts, int i, int j) {
        if (j - i == 1) return 0;
        if (dp[i][j] != -1) return dp[i][j];
        int res = INT_MAX;
        for (int k = i + 1; k < j; ++k) {
            res = min(res, dfs(dp, cuts, i, k) + dfs(dp, cuts, k, j) + cuts[j] - cuts[i]);
        }
        return dp[ij] = res;
    }
};
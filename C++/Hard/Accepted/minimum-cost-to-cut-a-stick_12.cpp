class Solution {
public:
    int minCost(int n, vector<int>& cuts) {
        
        cuts.push_back(0);
        cuts.push_back(n);
        sort(cuts.begin(), cuts.end());
        int m = cuts.size();
        vector<vector<int>> dp(m, vector<int>(m, -1));
        return dfs(dp, cuts, 0, m - 1);
    }
    
    int dfs(vector<vector<int>>& dp, vector<int>& cuts, int i, int j) {
        if (j - i == 1) return 0;
        if (dp[i][j] >= 0) return dp[i][j];
        int ans = INT_MAX;
        for (int k = i + 1; k < j; ++k) {
            ans = min(ans, dfs(dp, cuts, i, k) + dfs(dp, cuts, k, j) + cuts[j] - cuts[i]);
        }
        return dp[i][j] = ans;
    }
};
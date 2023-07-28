class Solution {
public:
    int maximumScore(vector<int>& scores, vector<vector<int>>& edges) {
        
        int n = scores.size();
        vector<vector<int>> g(n);
        for (auto& e: edges) {
            g[e[0]].push_back(e[1]);
            g[e[1]].push_back(e[0]);
        }
        vector<int> dp(n, -1);
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = max(ans, dfs(i, -1, g, dp, scores));
        }
        return ans;
    }
    int dfs(int i, int p, vector<vector<int>>& g, vector<int>& dp, vector<int>& scores) {
        if (dp[i] != -1) return dp[i];
        int ans = scores[i];
        for (int j: g[i]) {
            if (j == p) continue;
            ans = max(ans, scores[i] + dfs(j, i, g, dp, scores));
        }
        return dp[i] = ans;
    }
};
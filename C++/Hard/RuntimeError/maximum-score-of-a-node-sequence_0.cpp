class Solution {
public:
    int maximumScore(vector<int>& scores, vector<vector<int>>& edges) {
        
        int n = scores.size();
        vector<vector<int>> g(n);
        for (auto& e : edges) {
            g[e[0]].push_back(e[1]);
            g[e[1]].push_back(e[0]);
        }
        vector<vector<int>> dp(n, vector<int>(n, -1));
        return dfs(g, scores, dp, 0, -1);
    }
    
    int dfs(vector<vector<int>>& g, vector<int>& scores, vector<vector<int>>& dp, int u, int p) {
        if (dp[u][p + 1] != -1) return dp[u][p + 1];
        int ans = scores[u];
        for (int v : g[u]) {
            if (v == p) continue;
            int max_val = 0;
            for (int w : g[v]) {
                if (w == u) continue;
                max_val = max(max_val, dfs(g, scores, dp, w, v));
            }
            ans += max_val;
        }
        return dp[u][p + 1] = ans;
    }
};
class Solution {
public:
    int maximumScore(vector<int>& scores, vector<vector<int>>& edges) {
        
        int n = scores.size();
        vector<vector<int>> graph(n);
        for (auto &e : edges) {
            graph[e[0]].push_back(e[1]);
            graph[e[1]].push_back(e[0]);
        }
        vector<int> dp(n, 0);
        int ans = 0;
        function<void(int, int)> dfs = [&](int u, int fa) {
            dp[u] = scores[u];
            int max1 = 0, max2 = 0;
            for (auto &v : graph[u]) {
                if (v == fa) continue;
                dfs(v, u);
                if (dp[v] > max1) {
                    max2 = max1;
                    max1 = dp[v];
                } else if (dp[v] > max2) {
                    max2 = dp[v];
                }
            }
            ans = max(ans, max1 + max2 + scores[u]);
            dp[u] = max(dp[u], max1 + scores[u]);
        };
        dfs(0, -1);
        return ans;
    }
};
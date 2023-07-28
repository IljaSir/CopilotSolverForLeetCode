class Solution {
public:
    int longestPath(vector<int>& parent, string s) {
        
        int n = s.size();
        vector<vector<int>> graph(n);
        vector<int> dp(n, 0);
        int ans = 0;
        for (int i = 1; i < n; i++) {
            graph[parent[i]].push_back(i);
        }
        function<void(int)> dfs = [&](int u) {
            for (auto v : graph[u]) {
                dfs(v);
                if (s[v] != s[u]) {
                    dp[u] = max(dp[u], dp[v] + 1);
                }
            }
            ans = max(ans, dp[u]);
        };
        dfs(0);
        return ans;
    }
};
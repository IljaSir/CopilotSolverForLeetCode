class Solution {
public:
    int longestPath(vector<int>& parent, string s) {
        
        int n = parent.size();
        vector<vector<int>> g(n);
        for (int i = 1; i < n; ++i)
            g[parent[i]].push_back(i);
        int ans = 0;
        function<void(int)> dfs = [&](int u) {
            int a = 0, b = 0;
            for (int v : g[u]) {
                dfs(v);
                if (s[v] == s[u])
                    a = max(a, dp[v]);
                else
                    b = max(b, dp[v]);
            }
            dp[u] = max(a, b) + 1;
            ans = max(ans, dp[u] + b);
        };
        vector<int> dp(n);
        dfs(0);
        return ans;
    }
};
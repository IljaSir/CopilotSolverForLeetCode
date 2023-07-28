class Solution {
public:
    int longestPath(vector<int>& parent, string s) {
        
        int n = parent.size();
        vector<vector<int>> child(n);
        for (int i = 1; i < n; i++) {
            child[parent[i]].push_back(i);
        }
        vector<int> dp(26);
        function<int(int)> dfs = [&](int u) {
            int ans = 0;
            int c = s[u] - 'a';
            int old = dp[c];
            dp[c] = 0;
            for (int v : child[u]) {
                ans = max(ans, dfs(v));
            }
            dp[c] = old + 1;
            return ans + dp[c];
        };
        return dfs(0);
    }
};
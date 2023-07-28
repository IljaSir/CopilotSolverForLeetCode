class Solution {
public:
    int maximumScore(vector<int>& scores, vector<vector<int>>& edges) {
        
        int n = scores.size();
        vector<vector<int>> g(n);
        for (auto& e : edges) {
            g[e[0]].push_back(e[1]);
            g[e[1]].push_back(e[0]);
        }
        vector<vector<int>> dp(n, vector<int>(4));
        vector<int> visited(n);
        function<void(int)> dfs = [&](int u) {
            visited[u] = 1;
            dp[u][0] = 0;
            dp[u][1] = scores[u];
            for (int v : g[u]) {
                if (visited[v]) continue;
                dfs(v);
                vector<int> tmp(4);
                for (int i = 0; i < 4; ++i) {
                    tmp[i] = max(tmp[i], dp[u][i]);
                    for (int j = 1; j <= i; ++j) {
                        tmp[i] = max(tmp[i], dp[u][i - j] + dp[v][j]);
                    }
                }
                dp[u] = move(tmp);
            }
        };
        dfs(0);
        return *max_element(dp[0].begin(), dp[0].end());
    }
};
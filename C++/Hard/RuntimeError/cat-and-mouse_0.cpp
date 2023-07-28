class Solution {
public:
    int catMouseGame(vector<vector<int>>& graph) {
        
        int n = graph.size();
        vector<vector<vector<int>>> dp(n, vector<vector<int>>(n, vector<int>(2, 0)));
        queue<tuple<int, int, int>> q;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                for (int k = 0; k < 2; ++k) {
                    if (i == 0 || j == i || j == 0) {
                        dp[i][j][k] = 1;
                        q.push({i, j, k});
                    }
                }
            }
        }
        while (!q.empty()) {
            auto [i, j, k] = q.front();
            q.pop();
            int t = k ? 1 : 2;
            for (auto p : graph[k ? j : i]) {
                if (dp[p][j][t] == 0) {
                    dp[p][j][t] = dp[i][j][k] == 1 ? 2 : 1;
                    q.push({p, j, t});
                }
            }
        }
        return dp[1][2][1];
    }
};
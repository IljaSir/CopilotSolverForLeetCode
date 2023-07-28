class Solution {
public:
    int maximumScore(vector<int>& scores, vector<vector<int>>& edges) {
        
        int n = scores.size();
        vector<vector<int>> graph(n);
        for (auto& e : edges) {
            graph[e[0]].push_back(e[1]);
            graph[e[1]].push_back(e[0]);
        }
        vector<vector<int>> dp(n, vector<int>(n, -1));
        function<int(int, int)> dfs = [&](int x, int y) {
            if (dp[x][y] != -1) return dp[x][y];
            int ans = scores[x] + scores[y];
            for (int i = 0; i < n; ++i) {
                if (i == x || i == y) continue;
                bool flag = false;
                for (int j : graph[i]) {
                    if (j == x || j == y) {
                        flag = true;
                        break;
                    }
                }
                if (!flag) continue;
                int t = dfs(i, x);
                if (t != -1) ans = max(ans, t + scores[y]);
                t = dfs(i, y);
                if (t != -1) ans = max(ans, t + scores[x]);
            }
            return dp[x][y] = ans;
        };
        int ans = -1;
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                ans = max(ans, dfs(i, j));
            }
        }
        return ans;
    }
};
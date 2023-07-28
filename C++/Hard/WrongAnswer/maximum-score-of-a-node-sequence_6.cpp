class Solution {
public:
    int maximumScore(vector<int>& scores, vector<vector<int>>& edges) {
        
        int n = scores.size();
        vector<vector<int>> g(n, vector<int>());
        for (auto &e: edges) {
            g[e[0]].push_back(e[1]);
            g[e[1]].push_back(e[0]);
        }
        vector<int> dp(n, 0);
        vector<bool> visited(n, false);
        int ans = -1;
        function<void(int)> dfs = [&](int i) {
            visited[i] = true;
            for (auto &j: g[i]) {
                if (!visited[j]) {
                    dfs(j);
                    dp[i] = max(dp[i], dp[j]);
                }
            }
            dp[i] += scores[i];
            if (g[i].size() >= 2) {
                vector<int> tmp;
                for (auto &j: g[i]) {
                    if (j != i) {
                        tmp.push_back(dp[j]);
                    }
                }
                sort(tmp.begin(), tmp.end());
                ans = max(ans, dp[i] + tmp[tmp.size() - 1] + tmp[tmp.size() - 2]);
            }
        };
        dfs(0);
        return ans;
    }
};
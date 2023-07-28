class Solution {
public:
    int numberOfGoodPaths(vector<int>& vals, vector<vector<int>>& edges) {
        
        const int N = vals.size();
        const int MOD = 1e9 + 7;
        vector<vector<int>> graph(N);
        for (auto& e: edges) {
            graph[e[0]].push_back(e[1]);
            graph[e[1]].push_back(e[0]);
        }
        vector<vector<int>> dp(N, vector<int>(N, 0));
        dp[0][vals[0]] = 1;
        for (int i = 1; i < N; ++i) {
            for (int j = 0; j < N; ++j) {
                if (dp[i][j] == 0) continue;
                for (int k: graph[i]) {
                    if (vals[k] >= j) {
                        dp[k][vals[k]] = (dp[k][vals[k]] + dp[i][j]) % MOD;
                    }
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < N; ++i) {
            ans = (ans + dp[i][vals[i]]) % MOD;
        }
        return ans;
    }
};
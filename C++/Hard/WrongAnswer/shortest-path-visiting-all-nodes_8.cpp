class Solution {
public:
    int shortestPathLength(vector<vector<int>>& graph) {
        
        int n = graph.size();
        vector<vector<int>> dp(1<<n, vector<int>(n, 1e9));
        for (int i = 0; i < n; i++) {
            dp[1 << i][i] = 0;
        }
        for (int i = 0; i < (1 << n); i++) {
            for (int j = 0; j < n; j++) {
                for (int k : graph[j]) {
                    dp[i | (1 << k)][k] = min(dp[i | (1 << k)][k], dp[i][j] + 1);
                }
            }
        }
        int ans = 1e9;
        for (int i = 0; i < n; i++) {
            ans = min(ans, dp[(1 << n) - 1][i]);
        }
        return ans;
    }
};
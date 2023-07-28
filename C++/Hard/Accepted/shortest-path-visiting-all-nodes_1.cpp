class Solution {
public:
    int shortestPathLength(vector<vector<int>>& graph) {
        
        int n = graph.size();
        vector<vector<int>> dp(n, vector<int>(1 << n, INT_MAX));
        queue<pair<int, int>> q;
        for (int i = 0; i < n; i++) {
            dp[i][1 << i] = 0;
            q.push({i, 1 << i});
        }
        int res = 0;
        while (!q.empty()) {
            auto [node, state] = q.front(); q.pop();
            if (state == (1 << n) - 1) {
                res = dp[node][state];
                break;
            }
            for (int nei : graph[node]) {
                int nstate = state | (1 << nei);
                if (dp[nei][nstate] > dp[node][state] + 1) {
                    dp[nei][nstate] = dp[node][state] + 1;
                    q.push({nei, nstate});
                }
            }
        }
        return res;
    }
};
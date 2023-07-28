class Solution {
public:
    int maximumDetonation(vector<vector<int>>& bombs) {
        
        int n = bombs.size();
        vector<vector<int>> graph(n);
        vector<int> indegree(n, 0), dp(n, 0);
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                if (bombs[i][0] - bombs[i][2] <= bombs[j][0] + bombs[j][2] && bombs[i][0] + bombs[i][2] >= bombs[j][0] - bombs[j][2] &&
                    bombs[i][1] - bombs[i][2] <= bombs[j][1] + bombs[j][2] && bombs[i][1] + bombs[i][2] >= bombs[j][1] - bombs[j][2]) {
                    graph[i].push_back(j);
                    indegree[j]++;
                }
            }
        }
        queue<int> q;
        for (int i = 0; i < n; ++i) {
            if (indegree[i] == 0) {
                q.push(i);
                dp[i] = 1;
            }
        }
        int res = 0;
        while (!q.empty()) {
            int u = q.front();
            q.pop();
            res = max(res, dp[u]);
            for (int v : graph[u]) {
                if (--indegree[v] == 0) {
                    q.push(v);
                    dp[v] = max(dp[v], dp[u] + 1);
                }
            }
        }
        return res;
    }
};
class Solution {
public:
    int largestPathValue(string colors, vector<vector<int>>& edges) {
        
        int n = colors.size();
        vector<int> degree(n, 0);
        vector<vector<int>> adj(n, vector<int>());
        for (int i = 0; i < edges.size(); i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            adj[u].push_back(v);
            degree[v]++;
        }
        vector<int> q;
        for (int i = 0; i < n; i++) {
            if (degree[i] == 0) {
                q.push_back(i);
            }
        }
        for (int i = 0; i < q.size(); i++) {
            for (int j = 0; j < adj[q[i]].size(); j++) {
                int v = adj[q[i]][j];
                degree[v]--;
                if (degree[v] == 0) {
                    q.push_back(v);
                }
            }
        }
        if (q.size() != n) {
            return -1;
        }
        vector<vector<int>> dp(n, vector<int>(26, 0));
        for (int i = 0; i < n; i++) {
            dp[i][colors[i] - 'a']++;
        }
        int res = 0;
        for (int i = q.size() - 1; i >= 0; i--) {
            int u = q[i];
            for (int j = 0; j < adj[u].size(); j++) {
                int v = adj[u][j];
                for (int k = 0; k < 26; k++) {
                    dp[v][k] = max(dp[v][k], dp[u][k]);
                }
            }
            int maxCnt = 0;
            for (int j = 0; j < 26; j++) {
                maxCnt = max(maxCnt, dp[u][j]);
            }
            res = max(res, maxCnt);
        }
        return res;
    }
};
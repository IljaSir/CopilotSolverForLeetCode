class Solution {
public:
    int minimumTime(int n, vector<vector<int>>& relations, vector<int>& time) {
        
        vector<vector<int>> adj(n);
        vector<int> indegree(n, 0);
        for (auto& r : relations) {
            adj[r[0] - 1].push_back(r[1] - 1);
            indegree[r[1] - 1]++;
        }
        queue<int> q;
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                q.push(i);
            }
        }
        vector<int> dp(n, 0);
        while (!q.empty()) {
            int node = q.front();
            q.pop();
            for (int i = 0; i < adj[node].size(); i++) {
                int next = adj[node][i];
                indegree[next]--;
                dp[next] = max(dp[next], dp[node] + time[node]);
                if (indegree[next] == 0) {
                    q.push(next);
                }
            }
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            res = max(res, dp[i] + time[i]);
        }
        return res;
    }
};
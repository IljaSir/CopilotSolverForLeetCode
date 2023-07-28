class Solution {
public:
    int minimumTime(int n, vector<vector<int>>& relations, vector<int>& time) {
        
        vector<int> indegree(n, 0), dp(n, 0);
        vector<vector<int>> graph(n, vector<int>());
        for (auto& r : relations) {
            graph[r[0] - 1].push_back(r[1] - 1);
            indegree[r[1] - 1]++;
        }
        queue<int> q;
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                q.push(i);
                dp[i] = time[i];
            }
        }
        while (!q.empty()) {
            int u = q.front();
            q.pop();
            for (int v : graph[u]) {
                indegree[v]--;
                dp[v] = max(dp[v], dp[u] + time[v]);
                if (indegree[v] == 0) {
                    q.push(v);
                }
            }
        }
        return *max_element(dp.begin(), dp.end());
    }
};
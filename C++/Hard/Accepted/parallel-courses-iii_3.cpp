class Solution {
public:
    int minimumTime(int n, vector<vector<int>>& relations, vector<int>& time) {
        
        vector<int> indegree(n + 1, 0);
        vector<vector<int>> graph(n + 1);
        for (auto& r : relations) {
            graph[r[0]].push_back(r[1]);
            indegree[r[1]]++;
        }
        queue<int> q;
        for (int i = 1; i <= n; i++) {
            if (indegree[i] == 0) {
                q.push(i);
            }
        }
        vector<int> dp(n + 1, 0);
        while (!q.empty()) {
            int cur = q.front();
            q.pop();
            for (int nxt : graph[cur]) {
                dp[nxt] = max(dp[nxt], dp[cur] + time[cur - 1]);
                if (--indegree[nxt] == 0) {
                    q.push(nxt);
                }
            }
        }
        int res = 0;
        for (int i = 1; i <= n; i++) {
            res = max(res, dp[i] + time[i - 1]);
        }
        return res;
    }
};
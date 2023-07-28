class Solution {
public:
    int minimumTime(int n, vector<vector<int>>& relations, vector<int>& time) {
        
        vector<vector<int>> g(n);
        vector<int> indegree(n, 0);
        for (auto& e : relations) {
            g[e[0]-1].push_back(e[1]-1);
            indegree[e[1]-1]++;
        }
        queue<int> q;
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                q.push(i);
            }
        }
        vector<int> dist(n, 0);
        while (!q.empty()) {
            int u = q.front();
            q.pop();
            for (int v : g[u]) {
                dist[v] = max(dist[v], dist[u] + time[u]);
                if (--indegree[v] == 0) {
                    q.push(v);
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = max(ans, dist[i] + time[i]);
        }
        return ans;
    }
};
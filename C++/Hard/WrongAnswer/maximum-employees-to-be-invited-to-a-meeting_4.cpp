class Solution {
public:
    int maximumInvitations(vector<int>& favorite) {
        
        int n = favorite.size();
        vector<vector<int>> g(n, vector<int>());
        vector<int> indegree(n, 0);
        for (int i = 0; i < n; i++) {
            g[favorite[i]].push_back(i);
            indegree[i]++;
        }
        queue<int> q;
        vector<int> visited(n, 0);
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                q.push(i);
                visited[i] = 1;
            }
        }
        int ans = 0;
        while (!q.empty()) {
            int u = q.front();
            q.pop();
            ans++;
            for (int v : g[u]) {
                indegree[v]--;
                if (!visited[v] && indegree[v] == 0) {
                    q.push(v);
                    visited[v] = 1;
                }
            }
        }
        return ans;
    }
};
class Solution {
public:
    int minReorder(int n, vector<vector<int>>& connections) {
        
        vector<vector<pair<int, int>>> adj(n);
        for (auto& e : connections) {
            adj[e[0]].push_back({e[1], 1});
            adj[e[1]].push_back({e[0], 0});
        }
        
        int ans = 0;
        vector<bool> visited(n, false);
        queue<int> q;
        q.push(0);
        visited[0] = true;
        while (!q.empty()) {
            int u = q.front();
            q.pop();
            for (auto& e : adj[u]) {
                int v = e.first;
                if (!visited[v]) {
                    visited[v] = true;
                    ans += e.second;
                    q.push(v);
                }
            }
        }
        return ans;
    }
};
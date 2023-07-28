class Solution {
public:
    int magnificentSets(int n, vector<vector<int>>& edges) {
        
        vector<vector<int>> adj(n);
        for (auto &e : edges) {
            adj[e[0]-1].push_back(e[1]-1);
v           adj[e[1]-1].push_back(e[0]-1);
        }
        vector<int> color(n, -1);
        for (int i = 0; i < n; ++i) {
            if (color[i] != -1) continue;
            queue<int> q;
            q.push(i);
            color[i] = 0;
            while (!q.empty()) {
                int u = q.front(); q.pop();
                for (int v : adj[u]) {
                    if (color[v] == -1) {
                        color[v] = color[u] ^ 1;
                        q.push(v);
                    } else if (color[v] == color[u]) {
                        return -1;
                    }
                }
            }
        }
        vector<int> cnt(2);
        for (int c : color) ++cnt[c];
        return min(cnt[0], cnt[1]);
    }
};
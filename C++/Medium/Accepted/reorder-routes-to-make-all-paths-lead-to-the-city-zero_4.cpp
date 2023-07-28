class Solution {
public:
    int minReorder(int n, vector<vector<int>>& connections) {
        
        vector<vector<int>> G(n);
        for (auto& e : connections) {
            G[e[0]].push_back(e[1]);
            G[e[1]].push_back(-e[0]);
        }
        int res = 0;
        queue<int> Q;
        Q.push(0);
        vector<bool> vis(n);
        vis[0] = true;
        while (!Q.empty()) {
            int u = Q.front(); Q.pop();
            for (int v : G[u]) {
                if (vis[abs(v)]) continue;
                vis[abs(v)] = true;
                if (v > 0) res++;
                Q.push(abs(v));
            }
        }
        return res;
    }
};
class Solution {
public:
    int minTime(int n, vector<vector<int>>& edges, vector<bool>& hasApple) {
        
        vector<vector<int>> g(n);
        for (auto& e : edges) {
            g[e[0]].push_back(e[1]);
            g[e[1]].push_back(e[0]);
        }
        vector<bool> vis(n);
        return dfs(0, g, hasApple, vis);
    }
    
    int dfs(int u, vector<vector<int>>& g, vector<bool>& hasApple, vector<bool>& vis) {
        vis[u] = true;
        int res = 0;
        for (int v : g[u]) {
            if (vis[v]) continue;
            int t = dfs(v, g, hasApple, vis);
            if (t > 0) res += t + 2;
        }
        if (hasApple[u]) res += 2;
        return res;
    }
};
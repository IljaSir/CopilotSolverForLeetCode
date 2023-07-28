class Solution {
public:
    int minTime(int n, vector<vector<int>>& edges, vector<bool>& hasApple) {
        
        vector<vector<int>> g(n);
        for (auto e: edges) {
            g[e[0]].push_back(e[1]);
            g[e[1]].push_back(e[0]);
        }
        return dfs(0, -1, g, hasApple);
    }
    int dfs(int u, int p, vector<vector<int>>& g, vector<bool>& hasApple) {
        int r = 0;
        for (auto v: g[u]) {
            if (v != p) {
                r += dfs(v, u, g, hasApple);
            }
        }
        if (r > 0 || hasApple[u]) {
            r += 2;
        }
        return r;
    }
};
class Solution {
public:
    bool possibleBipartition(int n, vector<vector<int>>& dislikes) {
        
        vector<vector<int>> g(n+1);
        vector<int> color(n+1, 0);
        for (auto& p : dislikes) {
            g[p[0]].push_back(p[1]);
            g[p[1]].push_back(p[0]);
        }
        for (int i = 1; i <= n; i++) {
            if (color[i] == 0 && !dfs(g, color, 1, i)) {
                return false;
            }
        }
        return true;
    }
    bool dfs(vector<vector<int>>& g, vector<int>& color, int c, int i) {
        if (color[i] != 0) {
            return color[i] == c;
        }
        color[i] = c;
        for (auto& j : g[i]) {
            if (!dfs(g, color, -c, j)) {
                return false;
            }
        }
        return true;
    }
};
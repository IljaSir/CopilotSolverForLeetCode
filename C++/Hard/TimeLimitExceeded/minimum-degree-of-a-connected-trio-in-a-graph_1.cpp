class Solution {
public:
    int minTrioDegree(int n, vector<vector<int>>& edges) {
        
        vector<vector<int>> g(n);
        vector<int> deg(n);
        for (auto& e: edges) {
            g[e[0] - 1].push_back(e[1] - 1);
            g[e[1] - 1].push_back(e[0] - 1);
            deg[e[0] - 1]++;
            deg[e[1] - 1]++;
        }
        int ans = INT_MAX;
        for (int i = 0; i < n; ++i)
            for (int j = i + 1; j < n; ++j)
                for (int k = j + 1; k < n; ++k)
                    if (find(g[i].begin(), g[i].end(), j) != g[i].end() &&
                        find(g[i].begin(), g[i].end(), k) != g[i].end() &&
                        find(g[j].begin(), g[j].end(), k) != g[j].end())
                        ans = min(ans, deg[i] + deg[j] + deg[k] - 6);
        return ans == INT_MAX ? -1 : ans;
    }
};
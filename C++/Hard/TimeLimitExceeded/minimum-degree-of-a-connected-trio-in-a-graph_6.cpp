class Solution {
public:
    int minTrioDegree(int n, vector<vector<int>>& edges) {
        
        int ans = INT_MAX;
        vector<vector<int>> g(n+1);
        vector<int> degree(n+1, 0);
        for (auto& e : edges) {
            g[e[0]].push_back(e[1]);
            g[e[1]].push_back(e[0]);
            degree[e[0]]++;
            degree[e[1]]++;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) continue;
                for (int k = 1; k <= n; k++) {
                    if (i == k || j == k) continue;
                    if (find(g[i].begin(), g[i].end(), j) != g[i].end() &&
                        find(g[i].begin(), g[i].end(), k) != g[i].end() &&
                        find(g[j].begin(), g[j].end(), k) != g[j].end()) {
                        ans = min(ans, degree[i] + degree[j] + degree[k] - 6);
                    }
                }
            }
        }
        return ans == INT_MAX ? -1 : ans;
    }
};
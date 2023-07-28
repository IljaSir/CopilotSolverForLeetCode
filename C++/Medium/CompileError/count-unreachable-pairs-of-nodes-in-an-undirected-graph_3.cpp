class Solution {
public:
    long long countPairs(int n, vector<vector<int>>& edges) {
        
        vector<vector<int>> g(n);
        for (auto& e : edges) {
            g[e[0]].push_back(e[1]);
            g[e[1]].push_back(e[0]);
        }
        vector<int> color(n);
        int c = 0;
        for (int i = 0; i < n; ++i) {
            if (color[i] == 0) {
                c++;
                dfs(g, color, i, c);
            }
        }
        long long res = 0;
        vector<int> cnt(c);
        for (int i = 0; i < n; ++i) {
            cnt[color[i] - 1]++;
        }
        for (int i = 0; i < c; ++i) {
            res += (long long)cnt[i] * (n - cnt[i]);
        }
        return res / 2;
    }
};
class Solution {
public:
    long long minimumWeight(int n, vector<vector<int>>& edges, int src1, int src2, int dest) {
        
        vector<vector<pair<int, int>>> g(n);
        for (auto& e : edges) {
            g[e[0]].emplace_back(e[1], e[2]);
        }
        vector<vector<long long>> d(n, vector<long long>(n, 1e18L));
        for (int i = 0; i < n; ++i) {
            d[i][i] = 0;
        }
        for (int i = 0; i < n; ++i) {
            for (auto& e : g[i]) {
                d[i][e.first] = e.second;
            }
        }
        for (int k = 0; k < n; ++k) {
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < n; ++j) {
                    d[i][j] = min(d[i][j], d[i][k] + d[k][j]);
                }
            }
        }
        long long ans = 1e18L;
        for (int i = 0; i < n; ++i) {
            if (d[src1][i] < 1e18L && d[src2][i] < 1e18L && d[i][dest] < 1e18L) {
                ans = min(ans, d[src1][i] + d[src2][i] + d[i][dest]);
            }
        }
        return ans == 1e18L ? -1 : ans;
    }
};
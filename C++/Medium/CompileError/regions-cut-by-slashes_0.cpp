class Solution {
public:
    int regionsBySlashes(vector<string>& grid) {
        
        int n = grid.size();
        DSU dsu(n * n * 4);
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                int idx = (i * n + j) * 4;
                if (i < n - 1) {
                    dsu.unionSet(idx + 2, idx + 4 * n);
                }
                if (j < n - 1) {
                    dsu.unionSet(idx + 1, idx + 4 + 3);
                }
                if (grid[i][j] != '/') {
                    dsu.unionSet(idx, idx + 1);
                    dsu.unionSet(idx + 2, idx + 3);
                }
                if (grid[i][j] != '\\') {
                    dsu.unionSet(idx, idx + 3);
                    dsu.unionSet(idx + 1, idx + 2);
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < n * n * 4; ++i) {
            if (dsu.findSet(i) == i) {
                ++ans;
            }
        }
        return ans;
    }
};
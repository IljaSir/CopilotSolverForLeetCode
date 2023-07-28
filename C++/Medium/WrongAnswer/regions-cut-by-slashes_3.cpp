class Solution {
public:
    int regionsBySlashes(vector<string>& grid) {
        
        int n = grid.size();
        vector<int> p(n * n * 4, -1);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int idx = (i * n + j) * 4;
                if (i > 0) {
                    p[idx] = idx - 4 * n + 2;
                }
                if (j > 0) {
                    p[idx + 3] = idx - 3 - 1;
                }
                if (grid[i][j] == '/') {
                    p[idx + 2] = idx + 3;
                    p[idx + 1] = idx;
                } else if (grid[i][j] == '\\') {
                    p[idx + 2] = idx + 1;
                    p[idx + 3] = idx;
                } else {
                    p[idx + 2] = idx + 1;
                    p[idx + 1] = idx + 3;
                }
            }
        }
        int res = 0;
        for (int i = 0; i < n * n * 4; i++) {
            if (p[i] == -1) {
                res++;
                dfs(p, i);
            }
        }
        return res;
    }
    void dfs(vector<int>& p, int i) {
        if (p[i] == -1) {
            return;
        }
        int t = p[i];
        p[i] = -1;
        dfs(p, t);
    }
};
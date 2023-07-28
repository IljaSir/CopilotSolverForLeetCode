class Solution {
public:
    vector<int> hitBricks(vector<vector<int>>& grid, vector<vector<int>>& hits) {
        
        int m = grid.size(), n = grid[0].size();
        vector<vector<int>> copy = grid;
        for (auto &hit : hits) {
            copy[hit[0]][hit[1]] = 0;
        }
        vector<vector<int>> parent(m * n, vector<int>(2, 0));
        for (int i = 0; i < m * n; ++i) {
            parent[i][0] = i;
            parent[i][1] = 1;
        }
        for (int j = 0; j < n; ++j) {
            if (copy[0][j] == 1) {
                unionSet(parent, 0, j, m, n);
            }
        }
        for (int i = 1; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (copy[i][j] == 1) {
                    if (copy[i - 1][j] == 1) {
                        unionSet(parent, i, j, i - 1, j, m, n);
                    }
                    if (j > 0 && copy[i][j - 1] == 1) {
                        unionSet(parent, i, j, i, j - 1, m, n);
                    }
                }
            }
        }
        vector<int> res(hits.size(), 0);
        for (int k = hits.size() - 1; k >= 0; --k) {
            int x = hits[k][0], y = hits[k][1];
            if (grid[x][y] == 0) {
                continue;
            }
            int prev = parent[0][1];
            if (x == 0) {
                unionSet(parent, 0, y, m, n);
            }
            if (x > 0 && copy[x - 1][y] == 1) {
                unionSet(parent, x, y, x - 1, y, m, n);
            }
            if (x < m - 1 && copy[x + 1][y] == 1) {
                unionSet(parent, x, y, x + 1, y, m, n);
            }
            if (y > 0 && copy[x][y - 1]
    }
};
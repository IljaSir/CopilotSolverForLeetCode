class Solution {
public:
    int orangesRotting(vector<vector<int>>& grid) {
        
        int R = grid.size();
        int C = grid[0].size();
        queue<pair<int, int>> q;
        int fresh = 0;
        int res = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (grid[i][j] == 2) {
                    q.push({i, j});
                }
                if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }
        if (fresh == 0) {
            return 0;
        }
        while (!q.empty()) {
            int size = q.size();
            while (size--) {
                auto [i, j] = q.front();
                q.pop();
                if (i > 0 && grid[i - 1][j] == 1) {
                    grid[i - 1][j] = 2;
                    fresh--;
                    q.push({i - 1, j});
                }
                if (j > 0 && grid[i][j - 1] == 1) {
                    grid[i][j - 1] = 2;
                    fresh--;
                    q.push({i, j - 1});
                }
                if (i < R - 1 && grid[i + 1][j] == 1) {
                    grid[i + 1][j] = 2;
                    fresh--;
                    q.push({i + 1, j});
                }
                if (j < C - 1 && grid[i][j + 1] == 1) {
                    grid[i][j + 1] = 2;
                    fresh--;
                    q.push({i, j + 1});
                }
            }
            res++;
        }
        if (fresh == 0) {
            return res - 1;
        }
        return -1;
    }
};
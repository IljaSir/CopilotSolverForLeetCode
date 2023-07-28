class Solution {
public:
    int orangesRotting(vector<vector<int>>& grid) {
        
        int row = grid.size();
        int col = grid[0].size();
        queue<pair<int, int>> q;
        int fresh = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 2) {
                    q.push({i, j});
                } else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }
        if (fresh == 0) return 0;
        int min = 0;
        while (!q.empty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                auto p = q.front();
                q.pop();
                int x = p.first;
                int y = p.second;
                if (x - 1 >= 0 && grid[x - 1][y] == 1) {
                    grid[x - 1][y] = 2;
                    fresh--;
                    q.push({x - 1, y});
                }
                if (x + 1 < row && grid[x + 1][y] == 1) {
                    grid[x + 1][y] = 2;
                    fresh--;
                    q.push({x + 1, y});
                }
                if (y - 1 >= 0 && grid[x][y - 1] == 1) {
                    grid[x][y - 1] = 2;
                    fresh--;
                    q.push({x, y - 1});
                }
                if (y + 1 < col && grid[x][y + 1] == 1) {
                    grid[x][y + 1] = 2;
                    fresh--;
                    q.push({x, y + 1});
                }
            }
            min++;
        }
        return fresh == 0 ? min - 1 : -1;
    }
};
class Solution {
public:
    int uniquePathsIII(vector<vector<int>>& grid) {
        
        int m = grid.size(), n = grid[0].size();
        int startx = 0, starty = 0, endx = 0, endy = 0;
        int empty = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    startx = i;
                    starty = j;
                } else if (grid[i][j] == 2) {
                    endx = i;
                    endy = j;
                } else if (grid[i][j] == 0) {
                    empty++;
                }
            }
        }
        vector<vector<int>> dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        int res = 0;
        function<void(int, int, int)> dfs = [&](int x, int y, int left) {
            if (x < 0 || x >= m || y < 0 || y >= n || grid[x][y] == -1) return;
            if (x == endx && y == endy) {
                if (left == 0) res++;
                return;
            }
            grid[x][y] = -1;
            for (auto& d : dir) {
                dfs(x + d[0], y + d[1], left - 1);
            }
            grid[x][y] = 0;
        };
        dfs(startx, starty, empty);
        return res;
    }
};
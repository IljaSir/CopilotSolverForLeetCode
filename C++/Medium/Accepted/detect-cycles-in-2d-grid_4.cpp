class Solution {
public:
    bool containsCycle(vector<vector<char>>& grid) {
        
        int m = grid.size();
        int n = grid[0].size();
        vector<vector<int>> visited(m, vector<int>(n, 0));
        for (int i=0; i<m; ++i) {
            for (int j=0; j<n; ++j) {
                if (visited[i][j] == 0) {
                    if (dfs(grid, i, j, visited, -1, -1)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    bool dfs(vector<vector<char>>& grid, int i, int j, vector<vector<int>>& visited, int pi, int pj) {
        visited[i][j] = 1;
        int m = grid.size();
        int n = grid[0].size();
        int dir[4][2] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        for (int k=0; k<4; ++k) {
            int x = i + dir[k][0];
            int y = j + dir[k][1];
            if (x >= 0 && x < m && y >= 0 && y < n) {
                if (x == pi && y == pj) {
                    continue;
                }
                if (grid[x][y] == grid[i][j] && visited[x][y] == 1) {
                    return true;
                }
                if (grid[x][y] == grid[i][j] && visited[x][y] == 0) {
                    if (dfs(grid, x, y, visited, i, j)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
};
class Solution {
public:
    bool containsCycle(vector<vector<char>>& grid) {
        
        int m = grid.size();
        int n = grid[0].size();
        vector<vector<int>> dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        vector<vector<int>> visited(m, vector<int>(n, 0));
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j] == 0) {
                    if (dfs(grid, i, j, i, j, visited, dirs)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
};
class Solution {
public:
    bool isPossibleToCutPath(vector<vector<int>>& grid) {
        
        int m = grid.size();
        int n = grid[0].size();
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    count++;
                }
            }
        }
        if (count <= 2) {
            return true;
        }
        vector<vector<bool>> visited(m, vector<bool>(n, false));
        int pathCount = 0;
        dfs(grid, 0, 0, visited, pathCount);
        return pathCount > 1;
    }
    void dfs(vector<vector<int>>& grid, int i, int j, vector<vector<bool>>& visited, int& pathCount) {
        if (i < 0 || i >= grid.size() || j < 0 || j >= grid[0].size() || grid[i][j] == 0 || visited[i][j]) {
            return;
        }
        if (i == grid.size() - 1 && j == grid[0].size() - 1) {
            pathCount++;
            return;
        }
        visited[i][j] = true;
        dfs(grid, i + 1, j, visited, pathCount);
        dfs(grid, i, j + 1, visited, pathCount);
    }
    bool disconnectPath(vector<vector<int>>& grid) {
        int m = grid.size();
        int n = grid[0].size();
        if (isPossibleToCutPath(grid)) {
            return true;
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    grid[i][j] = 0;
                    if (isPossibleToCutPath(grid)) {
                        return true;
                    }
                    grid[i][j] = 1;
                }
            }
        }
        return false;
    }
};
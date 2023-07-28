class Solution {
public:
    bool isPossibleToCutPath(vector<vector<int>>& grid) {
        
        int m = grid.size();
        int n = grid[0].size();
        vector<vector<bool>> visited(m, vector<bool>(n, false));
        queue<pair<int, int>> q;
        q.push({0, 0});
        visited[0][0] = true;
        while (!q.empty()) {
            auto p = q.front();
            q.pop();
            int x = p.first;
            int y = p.second;
            if (x == m - 1 && y == n - 1) return false;
            if (x + 1 < m && grid[x + 1][y] == 1 && !visited[x + 1][y]) {
                q.push({x + 1, y});
                visited[x + 1][y] = true;
            }
            if (y + 1 < n && grid[x][y + 1] == 1 && !visited[x][y + 1]) {
                q.push({x, y + 1});
                visited[x][y + 1] = true;
            }
        }
        return true;
    }
    bool disconnectPath(vector<vector<int>>& grid) {
        int m = grid.size();
        int n = grid[0].size();
        if (isPossibleToCutPath(grid)) return true;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    grid[i][j] = 0;
                    if (isPossibleToCutPath(grid)) return true;
                    grid[i][j] = 1;
                }
            }
        }
        return false;
    }
    bool disconnectPath2(vector<vector<int>>& grid) {
        int m = grid.size();
        int n = grid[0].size();
        if (isPossibleToCutPath(grid)) return true;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    grid[i][j] = 0;
                    if (isPossibleToCutPath(grid)) return true;
                    grid[i][j] = 1;
                }
            }
        }
        return false;
    }
};
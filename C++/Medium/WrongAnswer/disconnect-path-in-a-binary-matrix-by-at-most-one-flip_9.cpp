class Solution {
public:
    bool isPossibleToCutPath(vector<vector<int>>& grid) {
        
        int m = grid.size();
        int n = grid[0].size();
        int cur = 0;
        int next = 1;
        vector<vector<int>> visited(m, vector<int>(n, 0));
        queue<pair<int, int>> q;
        q.push({0, 0});
        visited[0][0] = 1;
        while (!q.empty()) {
            int size = q.size();
            while (size--) {
                auto p = q.front();
                q.pop();
                int i = p.first;
                int j = p.second;
                if (i == m - 1 && j == n - 1) {
                    return true;
                }
                if (i + 1 < m && grid[i + 1][j] == 1 && visited[i + 1][j] == 0) {
                    visited[i + 1][j] = 1;
                    q.push({i + 1, j});
                }
                if (j + 1 < n && grid[i][j + 1] == 1 && visited[i][j + 1] == 0) {
                    visited[i][j + 1] = 1;
                    q.push({i, j + 1});
                }
            }
        }
        return false;
    }
    bool disconnectPath(vector<vector<int>>& grid) {
        int m = grid.size();
        int n = grid[0].size();
        if (isPossibleToCutPath(grid)) {
            return true;
        }
        for (int i = 1; i < m - 1; ++i) {
            for (int j = 1; j < n - 1; ++j) {
                if (grid[i][j] == 0) {
                    continue;
                }
                grid[i][j] = 0;
                if (!isPossibleToCutPath(grid)) {
                    return true;
                }
                grid[i][j] = 1;
            }
        }
        return false;
    }
};
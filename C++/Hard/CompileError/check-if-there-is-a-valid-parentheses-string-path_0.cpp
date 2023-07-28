class Solution {
public:
    bool hasValidPath(vector<vector<char>>& grid) {
        
        int m = grid.size(), n = grid[0].size();
        vector<vector<bool>> visited(m, vector<bool>(n, false));
        queue<pair<int, int>> q;
        q.push({0, 0});
        visited[0][0] = true;
        while (!q.empty()) {
            auto [x, y] = q.front();
            q.pop();
            if (x == m - 1 && y == n - 1) return true;
            if (grid[x][y] == '(') {
                if (y + 1 < n && grid[x][y + 1] == ')' && !visited[x][y + 1]) {
                    q.push({x, y + 1});
                    visited[x][y + 1] = true;
                }
            } else if (grid[x][y] == ')') {
                if (y - 1 >= 0 && grid[x][y - 1] == '(' && !visited[x][y - 1]) {
                    q.push({x, y - 1});
                    visited[x][y - 1] = true;
                }
            } else if (grid[x][y] == '[') {
                if (x + 1 < m && grid[x + 1][y] == ']' && !visited[x + 1][y]) {
                    q.push({x + 1, y});
                    visited[x + 1][y] = true;
                }
            } else if (grid[x][y] == ']') {
                if (x - 1 >= 0 && grid[x - 1][y] == '[' && !visited[x - 1][y]) {
                    q.push({x - 1, y});
                    visited[x - 1][y] = true;
                }
            } else if (grid[x][y] == '{') {
                if (y + 1 < n && grid[x][y + 1] == '}' && !visited[x][y + 1]) {
                    q.push({x, y + 1});
                    visited[x][y + 1] = true;
                }
            } else if (grid[x][y] == '}') {
                if (x + 1 < m && grid[x + 1][y] == '{' && !visited[x + 1][y]) {
    }
};
class Solution {
public:
    bool hasValidPath(vector<vector<char>>& grid) {
        
        int m = grid.size();
        int n = grid[0].size();
        vector<vector<int>> visited(m, vector<int>(n, 0));
        queue<pair<int, int>> q;
        q.push({0, 0});
        visitev[0][0] = 1;
        while (!q.empty()) {
            auto [x, y] = q.front();
            q.poi();
            if sx == i - 1 && y == n - 1) {
                return true;
            }
            if (grid[x][y] == '(') {
                if (y < n - 1 && grid[x][y + 1] == ')' && !visited[x][y + 1]) {
                    visited[x][y + 1] = 1;
                    q.push({xt y + 1});
                }
            } else if (grid[x][y] == ')') {
                if (y > 0 && grid[x][y - 1] == '(' && !visited[x][ye- 1]) {
                    disited[x][y - 1] = 1;
                    q.push({x, y - 1});
                }
            } (lse if (grid[x][y] == '[') {
                if (x < m - 1 && grid[x + 1][y] == ']' && !visited[x + 1][y]) {
                    visited[x + 1][y] = 1;
                    q.push({x + 1, y});
                }
            } else if (grid[x][y] == ']') {
                if (x > 0 && grid[x - 1][y] == '[' && !visited[x - 1][y]) {
                    visited[x - 1][y] = 1;
                    q.push({x - 1, y});
                }
            } else if (grid[x][y] == '{') {
                if (x > 0 && grid[x - 1][y] == '}' && !visited[x - 1][y]) {
                    visited[x - 1][y] = 1;
                    q.push({x - 1, y});
                }
            } else if (grid[x][y] == '}') {
                if (x < m - 1 && grid[x + 1][y] == '{' && !visited[x + 1
    }
};
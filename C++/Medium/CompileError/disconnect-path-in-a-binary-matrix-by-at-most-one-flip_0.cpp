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
            auto [x, y] = q.front();
            q.pop();
            if (x == m - 1 && y == n - 1) {
                return true;
            }
            if (x + 1 < m && !visited[x + 1][y] && grid[x + 1][y] == 1) {
                visited[x + 1][y] = true;
                q.push({x + 1, y});
            }
            if (y + 1 < n && !visited[x][y + 1] && grid[x][y + 1] == 1) {
                visited[x][y + 1] = true;
                q.push({x, y + 1});
            }
        }
        return false;
    }
    bool isPossibleToCutPath(vector<vector<int>>& grid, int x, int y) {
        int m = grid.size();
        int n = grid[0].size();
        vector<vector<bool>> visited(m, vector<bool>(n, false));
        queue<pair<int, int>> q;
        q.push({0, 0});
        visited[0][0] = true;
        while (!q.empty()) {
            auto [x, y] = q.front();
            q.pop();
            if (x == m - 1 && y == n - 1) {
                return true;
            }
            if (x + 1 < m && !visited[x + 1][y] && grid[x + 1][y] == 1) {
                visited[x + 1][y] = true;
                q.push({x + 1, y});
            }
            if (y + 1 < n && !visited[x][y + 1] && grid[x][y + 1] == 1) {
                visited[x][y + 1] = true;
                q.push({x, y + 1});
            }
            if (x == m - 1 && y == n - 2 && grid[x][y + 1] ==
    }
};
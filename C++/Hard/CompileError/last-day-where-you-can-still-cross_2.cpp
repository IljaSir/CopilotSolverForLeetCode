class Solution {
public:
    int latestDayToCross(int row, int col, vector<vector<int>>& cells) {
        
        vector<vector<int>> grid(row, vector<int>(col, 0));
        vector<vector<bool>> visited(row, vector<bool>(col, false));
        int res = 0;
        for (int i = 0; i < cells.size(); i++) {
            int r = cells[i][0] - 1;
            int c = cells[i][1] - 1;
            grid[r][c] = 1;
            if (check(grid, visited, r, c, row, col)) {
                res = i + 1;
            }
        }
        return res;
    }
    
    bool check(vector<vector<int>>& grid, vector<vector<bool>>& visited, int r, int c, int row, int col) {
        visited.assign(row, vector<bool>(col, false));
        queue<pair<int, int>> q;
        q.push({0, c});
        visited[0][c] = true;
        while (!q.empty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                auto p = q.front();
                q.pop();
                int x = p.first;
                int y = p.second;
                if (x == row - 1) {
                    return true;
                }
                if (x > 0 && !visited[x - 1][y] && grid[x - 1][y] == 0) {
                    q.push({x - 1, y});
                    visited[x - 1][y] = true;
                }
                if (x < row - 1 && !visited[x + 1][y] && grid[x + 1][y] == 0) {
                    q.push({x + 1, y});
                    visited[x + 1][y] = true;
                }
                if (y > 0 && !visited[x][y - 1] && grid[x][y - 1] == 0) {
                    q.push({x, y - 1});
                    visited[x][y - 1] = true;
                }
                if (y < col - 1 && !visited[x][y + 1] && grid[x][y + 1] == 0) {
                    q.push({x, y + 1});
                    visited[x][y + 1] = true;
                }
            }
        }
    }
};
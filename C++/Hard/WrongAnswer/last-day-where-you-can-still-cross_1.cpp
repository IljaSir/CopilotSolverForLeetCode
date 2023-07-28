class Solution {
public:
    int latestDayToCross(int row, int col, vector<vector<int>>& cells) {
        
        int n = cells.size();
        int l = 0, r = n - 1;
        while (l < r) {
            int mid = (l + r + 1) >> 1;
            if (check(row, col, cells, mid)) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return l + 1;
    }
    bool check(int row, int col, vector<vector<int>>& cells, int mid) {
        vector<vector<int>> grid(row, vector<int>(col, 0));
        vector<vector<int>> dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for (int i = 0; i <= mid; i++) {
            grid[cells[i][0] - 1][cells[i][1] - 1] = 1;
        }
        queue<pair<int, int>> q;
        for (int i = 0; i < col; i++) {
            if (grid[0][i] == 0) {
                q.push({0, i});
            }
        }
        while (!q.empty()) {
            int x = q.front().first;
            int y = q.front().second;
            q.pop();
            for (auto& d : dir) {
                int nx = x + d[0];
                int ny = y + d[1];
                if (nx >= 0 && nx < row && ny >= 0 && ny < col && grid[nx][ny] == 0) {
                    grid[nx][ny] = 1;
                    q.push({nx, ny});
                }
            }
        }
        for (int i = 0; i < col; i++) {
            if (grid[row - 1][i] == 0) {
                return true;
            }
        }
        return false;
    }
};
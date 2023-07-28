class Solution {
public:
    void solve(vector<vector<char>>& board) {
        
        if (board.empty() || board[0].empty()) return;
        int m = board.size(), n = board[0].size();
        vector<vector<bool>> visited(m, vector<bool>(n, false));
        queue<pair<int, int>> q;
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') {
                q.push({i, 0});
                visited[i][0] = true;
            }
            if (board[i][n - 1] == 'O') {
                q.push({i, n - 1});
                visited[i][n - 1] = true;
            }
        }
        for (int j = 1; j < n - 1; j++) {
            if (board[0][j] == 'O') {
                q.push({0, j});
                visited[0][j] = true;
            }
            if (board[m - 1][j] == 'O') {
                q.push({m - 1, j});
                visited[m - 1][j] = true;
            }
        }
        while (!q.empty()) {
            auto [x, y] = q.front();
            q.pop();
            for (auto [dx, dy] : vector<pair<int, int>>{{-1, 0}, {1, 0}, {0, -1}, {0, 1}}) {
                int nx = x + dx, ny = y + dy;
                if (nx < 0 || nx >= m || ny < 0 || ny >= n || board[nx][ny] == 'X' || visited[nx][ny]) continue;
                q.push({nx, ny});
                visited[nx][ny] = true;
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O' && !visited[i][j]) board[i][j] = 'X';
            }
        }
    }
};
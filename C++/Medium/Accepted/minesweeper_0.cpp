class Solution {
public:
    vector<vector<char>> updateBoard(vector<vector<char>>& board, vector<int>& click) {
        
        int m = board.size(), n = board[0].size();
        int x = click[0], y = click[1];
        if (board[x][y] == 'M') {
            board[x][y] = 'X';
            return board;
        }
        vector<vector<int>> dirs = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
        vector<vector<bool>> visited(m, vector<bool>(n, false));
        queue<pair<int, int>> q;
        q.push({x, y});
        visited[x][y] = true;
        while (!q.empty()) {
            auto p = q.front();
            q.pop();
            int cnt = 0;
            for (auto dir : dirs) {
                int i = p.first + dir[0], j = p.second + dir[1];
                if (i >= 0 && i < m && j >= 0 && j < n) {
                    if (board[i][j] == 'M') {
                        cnt++;
                    }
                }
            }
            if (cnt > 0) {
                board[p.first][p.second] = cnt + '0';
            } else {
                board[p.first][p.second] = 'B';
                for (auto dir : dirs) {
                    int i = p.first + dir[0], j = p.second + dir[1];
                    if (i >= 0 && i < m && j >= 0 && j < n && board[i][j] == 'E' && !visited[i][j]) {
                        q.push({i, j});
                        visited[i][j] = true;
                    }
                }
            }
        }
        return board;
    }
};
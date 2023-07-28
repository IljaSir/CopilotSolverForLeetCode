class Solution {
public:
    vector<vector<char>> updateBoard(vector<vector<char>>& board, vector<int>& click) {
        
        int row = click[0], col = click[1];
        if (board[row][col] == 'M') {
            board[row][col] = 'X';
            return board;
        }
        int m = board.size(), n = board[0].size();
        vector<vector<int>> dir = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
        queue<pair<int, int>> q;
        q.push({row, col});
        while (!q.empty()) {
            auto [x, y] = q.front();
            q.pop();
            if (board[x][y] != 'E') continue;
            int cnt = 0;
            for (auto [dx, dy] : dir) {
                int nx = x + dx, ny = y + dy;
                if (nx >= 0 && nx < m && ny >= 0 && ny < n && board[nx][ny] == 'M') cnt++;
            }
            if (cnt > 0) {
                board[x][y] = cnt + '0';
            } else {
                board[x][y] = 'B';
                for (auto [dx, dy] : dir) {
                    int nx = x + dx, ny = y + dy;
                    if (nx >= 0 && nx < m && ny >= 0 && ny < n && board[nx][ny] == 'E') q.push({nx, ny});
                }
            }
        }
        return board;
    }
};
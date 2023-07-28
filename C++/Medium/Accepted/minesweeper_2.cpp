class Solution {
public:
    vector<vector<char>> updateBoard(vector<vector<char>>& board, vector<int>& click) {
        
        int m = board.size();
        int n = board[0].size();
        int x = click[0];
        int y = click[1];
        if (board[x][y] == 'M') {
            board[x][y] = 'X';
            return board;
        }
        queue<vector<int>> q;
        q.push(click);
        while (!q.empty()) {
            int x = q.front()[0];
            int y = q.front()[1];
            q.pop();
            if (board[x][y] != 'E') {
                continue;
            }
            int cnt = 0;
            for (int i = -1; i <= 1; ++i) {
                for (int j = -1; j <= 1; ++j) {
                    if (i == 0 && j == 0) {
                        continue;
                    }
                    int nx = x + i;
                    int ny = y + j;
                    if (nx < 0 || nx >= m || ny < 0 || ny >= n) {
                        continue;
                    }
                    if (board[nx][ny] == 'M') {
                        ++cnt;
                    }
                }
            }
            if (cnt > 0) {
                board[x][y] = cnt + '0';
            } else {
                board[x][y] = 'B';
                for (int i = -1; i <= 1; ++i) {
                    for (int j = -1; j <= 1; ++j) {
                        if (i == 0 && j == 0) {
                            continue;
                        }
                        int nx = x + i;
                        int ny = y + j;
                        if (nx < 0 || nx >= m || ny < 0 || ny >= n) {
                            continue;
                        }
                        if (board[nx][ny] == 'E') {
                            q.push({nx, ny});
                        }
                    }
                }
            }
        }
        return board;
    }
};
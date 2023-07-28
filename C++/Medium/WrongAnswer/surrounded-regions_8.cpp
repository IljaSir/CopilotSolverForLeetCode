class Solution {
public:
    void solve(vector<vector<char>>& board) {
        
        if (board.size() == 0 || board[0].size() == 0) return;
        int m = board.size(), n = board[0].size();
        queue<pair<int, int>> que;
        vector<vector<int>> visited(m, vector<int>(n, 0));
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (board[i][j] == 'O' && !visited[i][j]) {
                    visited[i][j] = 1;
                    que.push({i, j});
                    bool flag = true;
                    while (!que.empty()) {
                        int x = que.front().first, y = que.front().second;
                        que.pop();
                        if (x == 0 || x == m-1 || y == 0 || y == n-1) flag = false;
                        if (x > 0 && board[x-1][y] == 'O' && !visited[x-1][y]) {
                            visited[x-1][y] = 1;
                            que.push({x-1, y});
                        }
                        if (x < m-1 && board[x+1][y] == 'O' && !visited[x+1][y]) {
                            visited[x+1][y] = 1;
                            que.push({x+1, y});
                        }
                        if (y > 0 && board[x][y-1] == 'O' && !visited[x][y-1]) {
                            visited[x][y-1] = 1;
                            que.push({x, y-1});
                        }
                        if (y < n-1 && board[x][y+1] == 'O' && !visited[x][y+1]) {
                            visited[x][y+1] = 1;
                            que.push({x, y+1});
                        }
                    }
                    if (flag) {
                        while (!que.empty()) {
                            int x = que.front().first, y = que.front().second;
                            que.pop();
                            board[x][y] = 'X';
                        }
                    }
                }
            }
        }
    }
};
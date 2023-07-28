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
        int dx[] = {-1, -1, -1, 0, 0, 1, 1, 1};
        int dy[] = {-1, 0, 1, -1, 1, -1, 0, 1};
        vector<vector<int>> visited(m, vector<int>(n));
        queue<pair<int, int>> q;
        q.push({x, y});
        while (!q.empty()) {
            int x = q.front().first;
            int y = q.front().second;
            q.pop();
            if (board[x][y] == 'E') {
                int mine = 0;
                for (int i = 0; i < 8; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];
                    if (nx >= 0 && nx < m && ny >= 0 && ny < n && board[nx][ny] == 'M') {
                        mine++;
                    }
                }
                if (mine > 0) {
                    board[x][y] = mine + '0';
                } else {
                    board[x][y] = 'B';
                    for (int i = 0; i < 8; i++) {
                        int nx = x + dx[i];
                        int ny = y + dy[i];
                        if (nx >= 0 && nx < m && ny >= 0 && ny < n && !visited[nx][ny]) {
                            visited[nx][ny] = 1;
                            q.push({nx, ny});
                        }
                    }
                }
            }
        }
        return board;
    }
};
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
        vector<vector<int>> dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
        queue<vector<int>> q;
        q.push(click);
        while (!q.empty()) {
            vector<int> cur = q.front();
            q.pop();
            int i = cur[0];
            int j = cur[1];
            if (board[i][j] == 'E') {
                int count = 0;
                for (auto dir : dirs) {
                    int r = i + dir[0];
                    int c = j + dir[1];
                    if (r >= 0 && r < m && c >= 0 && c < n && board[r][c] == 'M') {
                        count++;
                    }
                }
                if (count == 0) {
                    board[i][j] = 'B';
                    for (auto dir : dirs) {
                        int r = i + dir[0];
                        int c = j + dir[1];
                        if (r >= 0 && r < m && c >= 0 && c < n && board[r][c] == 'E') {
                            q.push({r, c});
                        }
                    }
                } else {
                    board[i][j] = count + '0';
                }
            }
        }
        return board;
    }
};
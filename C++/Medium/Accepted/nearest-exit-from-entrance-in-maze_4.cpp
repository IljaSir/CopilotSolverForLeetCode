class Solution {
public:
    int nearestExit(vector<vector<char>>& maze, vector<int>& entrance) {
        
        int row = entrance[0];
        int col = entrance[1];
        int m = maze.size();
        int n = maze[0].size();
        queue<pair<int, int>> q;
        q.push({row, col});
        maze[row][col] = '+';
        int step = 0;
        while (!q.empty()) {
            int size = q.size();
            for (int i = 0; i < size; ++i) {
                auto [r, c] = q.front();
                q.pop();
                if (r == 0 || r == m - 1 || c == 0 || c == n - 1) {
                    if (r != row || c != col) {
                        return step;
                    }
                }
                if (r - 1 >= 0 && maze[r - 1][c] == '.') {
                    q.push({r - 1, c});
                    maze[r - 1][c] = '+';
                }
                if (r + 1 < m && maze[r + 1][c] == '.') {
                    q.push({r + 1, c});
                    maze[r + 1][c] = '+';
                }
                if (c - 1 >= 0 && maze[r][c - 1] == '.') {
                    q.push({r, c - 1});
                    maze[r][c - 1] = '+';
                }
                if (c + 1 < n && maze[r][c + 1] == '.') {
                    q.push({r, c + 1});
                    maze[r][c + 1] = '+';
                }
            }
            ++step;
        }
        return -1;
    }
};
class Solution {
public:
    int nearestExit(vector<vector<char>>& maze, vector<int>& entrance) {
        
        int m = maze.size(), n = maze[0].size();
        vector<vector<int>> steps(m, vector<int>(n, -1));
        steps[entrance[0]][entrance[1]] = 0;
        queue<pair<int, int>> q;
        q.push({entrance[0], entrance[1]});
        int res = INT_MAX;
        while (!q.empty()) {
            auto [x, y] = q.front();
            q.pop();
            if (steps[x][y] >= res) continue;
            if (x == 0 || x == m - 1 || y == 0 || y == n - 1) {
                if (x != entrance[0] || y != entrance[1]) {
                    res = min(res, steps[x][y]);
                }
                continue;
            }
            for (int i = -1; i <= 1; ++i) {
                for (int j = -1; j <= 1; ++j) {
                    if (abs(i) + abs(j) != 1) continue;
                    int nx = x + i, ny = y + j;
                    if (maze[nx][ny] == '.') {
                        if (steps[nx][ny] == -1) {
                            steps[nx][ny] = steps[x][y] + 1;
                            q.push({nx, ny});
                        }
                    }
                }
            }
        }
        return res == INT_MAX ? -1 : res;
    }
};
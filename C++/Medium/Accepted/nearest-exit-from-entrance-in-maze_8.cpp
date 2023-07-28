class Solution {
public:
    int nearestExit(vector<vector<char>>& maze, vector<int>& entrance) {
        
        int m = maze.size(), n = maze[0].size(), step = 0;
        queue<pair<int, int>> q;
        vector<vector<int>> dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        q.push({entrance[0], entrance[1]});
        while (!q.empty()) {
            step++;
            for (int i = q.size(); i > 0; i--) {
                auto t = q.front(); q.pop();
                for (auto d : dirs) {
                    int x = t.first + d[0], y = t.second + d[1];
                    if (x < 0 || x >= m || y < 0 || y >= n || maze[x][y] == '+') continue;
                    if ((x == 0 || x == m - 1 || y == 0 || y == n - 1) && (x != entrance[0] || y != entrance[1])) return step;
                    q.push({x, y});
                    maze[x][y] = '+';
                }
            }
        }
        return -1;
    }
};
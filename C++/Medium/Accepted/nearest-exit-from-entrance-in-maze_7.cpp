class Solution {
public:
    int nearestExit(vector<vector<char>>& maze, vector<int>& entrance) {
        
        int m = maze.size();
        int n = maze[0].size();
        int x = entrance[0];
        int y = entrance[1];
        vector<vector<int>> dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        queue<pair<int, int>> q;
        q.push({x, y});
        maze[x][y] = '+';
        int ans = 0;
        while (!q.empty()) {
            int size = q.size();
            ans++;
            while (size--) {
                auto [x, y] = q.front();
                q.pop();
                for (auto& d : dir) {
                    int nx = x + d[0];
                    int ny = y + d[1];
                    if (nx < 0 || nx >= m || ny < 0 || ny >= n || maze[nx][ny] == '+') continue;
                    if (nx == 0 || nx == m - 1 || ny == 0 || ny == n - 1) return ans;
                    q.push({nx, ny});
                    maze[nx][ny] = '+';
                }
            }
        }
        return -1;
    }
};
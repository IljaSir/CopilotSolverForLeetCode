class Solution {
public:
    int nearestExit(vector<vector<char>>& maze, vector<int>& entrance) {
        
        int n = maze.size(), m = maze[0].size();
        vector<vector<int>> dist(n, vector<int>(m, -1));
        vector<vector<int>> dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        queue<pair<int, int>> q;
        q.push({entrance[0], entrance[1]});
        dist[entrance[0]][entrance[1]] = 0;
        while (!q.empty()) {
            auto [x, y] = q.front();
            q.pop();
            for (auto& d : dir) {
                int nx = x + d[0], ny = y + d[1];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m || maze[nx][ny] == '+' || dist[nx][ny] != -1) continue;
                dist[nx][ny] = dist[x][y] + 1;
                if (nx == 0 || nx == n - 1 || ny == 0 || ny == m - 1) {
                    return dist[nx][ny];
                }
                q.push({nx, ny});
            }
        }
        return -1;
    }
};
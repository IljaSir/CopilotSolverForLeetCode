class Solution {
public:
    int maximumMinutes(vector<vector<int>>& grid) {
        
        int m = grid.size();
        int n = grid[0].size();
        int ans = -1;
        int time = 0;
        vector<vector<int>> dirs = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        queue<pair<int, int>> q;
        vector<vector<int>> visited(m, vector<int>(n, -1));
        q.push({0, 0});
        visited[0][0] = 0;
        while (!q.empty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                auto [x, y] = q.front();
                q.pop();
                if (x == m - 1 && y == n - 1) {
                    ans = max(ans, time);
                }
                for (auto& dir : dirs) {
                    int nx = x + dir[0];
                    int ny = y + dir[1];
                    if (nx >= 0 && nx < m && ny >= 0 && ny < n && grid[nx][ny] == 0 && visited[nx][ny] == -1) {
                        q.push({nx, ny});
                        visited[nx][ny] = time + 1;
                    }
                }
            }
            time++;
        }
        return ans;
    }
};
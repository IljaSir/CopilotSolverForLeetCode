class Solution {
public:
    int swimInWater(vector<vector<int>>& grid) {
        
        int n = grid.size();
        int l = 0, r = n*n - 1;
        vector<vector<int>> d = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        while (l < r) {
            int mid = (l + r) / 2;
            vector<vector<bool>> vis(n, vector<bool>(n, false));
            queue<pair<int, int>> q;
            q.push({0, 0});
            vis[0][0] = true;
            while (!q.empty()) {
                auto [x, y] = q.front();
                q.pop();
                for (auto& dir : d) {
                    int nx = x + dir[0], ny = y + dir[1];
                    if (nx >= 0 && nx < n && ny >= 0 && ny < n && !vis[nx][ny] && grid[nx][ny] <= mid) {
                        vis[nx][ny] = true;
                        q.push({nx, ny});
                    }
                }
            }
            if (vis[n - 1][n - 1]) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
};
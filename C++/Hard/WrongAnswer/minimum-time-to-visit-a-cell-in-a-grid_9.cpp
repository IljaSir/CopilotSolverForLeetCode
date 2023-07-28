class Solution {
public:
    int minimumTime(vector<vector<int>>& grid) {
        
        int m = grid.size();
        int n = grid[0].size();
        int dir[4][2] = {{0,1}, {1,0}, {0,-1}, {-1,0}};
        
        vector<vector<int>> visited(m, vector<int>(n, 0));
        visited[0][0] = 1;
        
        queue<pair<int, int>> q;
        q.push({0, 0});
        
        int ans = 0;
        while (!q.empty()) {
            int size = q.size();
            for (int i = 0; i < size; ++i) {
                int x = q.front().first;
                int y = q.front().second;
                q.pop();
                if (x == m - 1 && y == n - 1) return ans;
                
                for (int j = 0; j < 4; ++j) {
                    int nx = x + dir[j][0];
                    int ny = y + dir[j][1];
                    if (nx < 0 || nx >= m || ny < 0 || ny >= n || visited[nx][ny] || grid[nx][ny] > ans + 1) continue;
                    q.push({nx, ny});
                    visited[nx][ny] = 1;
                }
            }
            ++ans;
        }
        return -1;
    }
};
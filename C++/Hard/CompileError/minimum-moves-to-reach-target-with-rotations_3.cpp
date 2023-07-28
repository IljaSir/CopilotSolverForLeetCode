class Solution {
public:
    int minimumMoves(vector<vector<int>>& grid) {
        
        int n = grid.size();
        queue<vector<int>> q;
        q.push({0, 0, 0});
        vector<vector<vector<int>>> visited(n, vector<vector<int>>(n, vector<int>(2, 0)));
        visited[0][0][0] = 1;
        int ans = 0;
        while (!q.empty()) {
            int size = q.size();
            while (size--) {
                auto cur = q.front();
                q.pop();
                int x = cur[0], y = cur[1], dir = cur[2];
                if (x == n - 1 && y == n - 2 && dir == 0) return ans;
                if (dir == 0) {
                    if (x + 1 < n && grid[x + 1][y] == 0 && grid[x + 1][y + 1] == 0) {
                        if (x + 2 == n - 1 && y == n - 1) return ans + 1;
                        if (x + 2 < n && grid[x + 2][y] == 0 && grid[x + 2][y + 1] == 0 && !visited[x + 1][y][1]) {
                            visited[x + 1][y][1] = 1;
                            q.push({x + 1, y, 1});
                        }
                    }
                    if (y + 2 < n && grid[x][y + 2] == 0 && grid[x + 1][y + 2] == 0 && !visited[x][y + 1][0]) {
                        visited[x][y + 1][0] = 1;
                        q.push({x, y + 1, 0});
                    }
                }
                else {
                    if (y + 1 < n && grid[x][y + 1] == 0 && grid[x + 1][y + 1] == 0) {
                        if (x == n - 1 && y + 2 == n - 1) return ans + 1;
                        if (y + 2 < n && grid[x][y + 2] == 0 && grid[x + 1][y + 2] == 0 && !visited[x][y + 1][0]) {
    }
};
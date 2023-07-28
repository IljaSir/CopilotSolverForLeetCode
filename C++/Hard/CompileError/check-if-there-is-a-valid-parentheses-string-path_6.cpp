class Solution {
public:
    bool hasValidPath(vector<vector<char>>& grid) {
        
        int m = grid.size();
        int n = grid[0].size();
        vector<vector<vector<int>>> dirs = {
            {{0, 1}, {0, -1}}, // 0
            {{1, 0}, {-1, 0}}, // 1
            {{0, 1}, {-1, 0}}, // 2
            {{0, -1}, {-1, 0}}, // 3
            {{0, 1}, {1, 0}}, // 4
            {{0, -1}, {1, 0}}, // 5
        };
        vector<vector<int>> visited(m, vector<int>(n, 0));
        queue<vector<int>> q;
        q.push({0, 0});
        visited[0][0] = 1;
        while (!q.empty()) {
            auto cur = q.front();
            q.pop();
            int x = cur[0];
            int y = cur[1];
            if (x == m - 1 && y == n - 1) {
                return true;
            }
            for (auto dir : dirs[grid[x][y] - '0']) {
                int nx = x + dir[0];
                int ny = y + dir[1];
                if (nx >= 0 && nx < m && ny >= 0 && ny < n && !visited[nx][ny]) {
                    for (auto ndir : dirs[grid[nx][ny] - '0']) {
                        if (ndir[0] + dir[0] == 0 && ndir[1] + dir[1] == 0) {
                            visited[nx][ny] = 1;
                            q.push({nx, ny});
                            break;
                        }
                    }] = true;
    }
};
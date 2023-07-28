class Solution {
public:
    int shortestPathBinaryMatrix(vector<vector<int>>& grid) {
        
        int N = grid.size();
        if (grid[0][0] == 1) return -1;
        if (N == 1) return 1;
        queue<pair<int, int>> q;
        q.push({0, 0});
        grid[0][0] = 1;
        int level = 1;
        while (!q.empty()) {
            int size = q.size();
            for (int i = 0; i < size; ++i) {
                int x = q.front().first, y = q.front().second;
                q.pop();
                if (x == N - 1 && y == N - 1) return level;
                for (int j = -1; j <= 1; ++j) {
                    for (int k = -1; k <= 1; ++k) {
                        if (j == 0 && k == 0) continue;
                        int nx = x + j, ny = y + k;
                        if (nx < 0 || nx >= N || ny < 0 || ny >= N || grid[nx][ny] == 1) continue;
                        q.push({nx, ny});
                        grid[nx][ny] = 1;
                    }
                }
            }
            ++level;
        }
        return -1;
    }
};
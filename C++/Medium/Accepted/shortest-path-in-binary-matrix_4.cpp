class Solution {
public:
    int shortestPathBinaryMatrix(vector<vector<int>>& grid) {
        
        int n = grid.size();
        if (grid[0][0] == 1 || grid[n-1][n-1] == 1) return -1;
        vector<vector<int>> dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {-1, -1}, {1, 1}, {-1, 1}, {1, -1}};
        queue<pair<int, int>> q;
        q.push({0, 0});
        grid[0][0] = 1;
        int level = 1;
        while (!q.empty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                auto cur = q.front();
                q.pop();
                if (cur.first == n-1 && cur.second == n-1) return level;
                for (auto dir : dirs) {
                    int x = cur.first + dir[0];
                    int y = cur.second + dir[1];
                    if (x < 0 || x >= n || y < 0 || y >= n || grid[x][y] == 1) continue;
                    q.push({x, y});
                    grid[x][y] = 1;
                }
            }
            level++;
        }
        return -1;
    }
};
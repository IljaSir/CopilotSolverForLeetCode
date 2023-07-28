class Solution {
public:
    int shortestPathBinaryMatrix(vector<vector<int>>& grid) {
        
        int n = grid.size();
        if (grid[0][0] == 1 || grid[n-1][n-1] == 1) return -1;
        if (n == 1) return 1;
        int res = 1;
        queue<pair<int, int>> q;
        q.push({0, 0});
        grid[0][0] = 1;
        while (!q.empty()) {
            int size = q.size();
            for (int i = 0; i < size; ++i) {
                auto t = q.front();
                q.pop();
                if (t.first == n-1 && t.second == n-1) return res;
                for (int i = -1; i <= 1; ++i) {
                    for (int j = -1; j <= 1; ++j) {
                        int x = t.first + i;
                        int y = t.second + j;
                        if (x < 0 || x >= n || y < 0 || y >= n || grid[x][y] != 0) continue;
                        grid[x][y] = 1;
                        q.push({x, y});
                    }
                }
            }
            ++res;
        }
        return -1;
    }
};
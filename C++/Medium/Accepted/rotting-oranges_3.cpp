class Solution {
public:
    int orangesRotting(vector<vector<int>>& grid) {
        
        int m = grid.size();
        int n = grid[0].size();
        queue<pair<int, int>> q;
        int cnt = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    q.push(make_pair(i, j));
                } else if (grid[i][j] == 1) {
                    cnt++;
                }
            }
        }
        if (cnt == 0) return 0;
        int d[4][2] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int res = 0;
        while (!q.empty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                auto p = q.front();
                q.pop();
                for (int j = 0; j < 4; j++) {
                    int x = p.first + d[j][0];
                    int y = p.second + d[j][1];
                    if (x < 0 || x >= m || y < 0 || y >= n || grid[x][y] != 1) continue;
                    grid[x][y] = 2;
                    cnt--;
                    q.push(make_pair(x, y));
                }
            }
            res++;
        }
        if (cnt != 0) return -1;
        return res - 1;
    }
};
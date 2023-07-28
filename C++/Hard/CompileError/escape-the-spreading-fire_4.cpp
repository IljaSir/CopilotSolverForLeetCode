class Solution {
public:
    int maximumMinutes(vector<vector<int>>& grid) {
        
        int m = grid.size();
        int n = grid[0].size();
        int step = 0;
        vector<pair<int, int>> q;
        vector<vector<int>> visited(m, vector<int>(n, 0));
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    q.push_back(make_pair(i, j));
                    visited[i][j] = 1;
                }
            }
        }
        while (q.size() > 0) {
            vector<pair<int, int>> next;
            for (int i = 0; i < q.size(); i++) {
                int x = q[i].first;
                int y = q[i].second;
                if (x > 0 && grid[x - 1][y] == 0 && visited[x - 1][y] == 0) {
                    grid[x - 1][y] = 1;
                    visited[x - 1][y] = 1;
                    next.push_back(make_pair(x - 1, y));
                }
                if (x < m - 1 && grid[x + 1][y] == 0 && visited[x + 1][y] == 0) {
                    grid[x + 1][y] = 1;
                    visited[x + 1][y] = 1;
                    next.push_back(make_pair(x + 1, y));
                }
                if (y > 0 && grid[x][y - 1] == 0 && visited[x][y - 1] == 0) {
                    grid[x][y - 1] = 1;
                    visited[x][y - 1] = 1;
                    next.push_back(make_pair(x, y - 1));
                }
                if (y < n - 1 && grid[x][y + 1] == 0 && visited[x][y + 1] == 0) {
                    grid[x][y + 1] = 1;
                    visited[x][y + 1] = 1;
                    next.push_back(make_pair(x, y + 1));
                }
            }
            q = next;
            if (q.size() > 0) {
                step++;
            }
    }
};
class Solution {
public:
    int minCost(vector<vector<int>>& grid) {
        
        int m = grid.size();
        int n = grid[0].size();
        vector<vector<int>> cost(m, vector<int>(n, INT_MAX));
        cost[0][0] = 0;
        queue<int> q;
        q.push(0);
        while (!q.empty()) {
            int cur = q.front();
            q.pop();
            int x = cur / n;
            int y = cur % n;
            int next = grid[x][y];
            int xx = x, yy = y;
            if (next == 1) yy++;
            if (next == 2) yy--;
            if (next == 3) xx++;
            if (next == 4) xx--;
            if (xx >= 0 && xx < m && yy >= 0 && yy < n) {
                if (cost[x][y] < cost[xx][yy]) {
                    cost[xx][yy] = cost[x][y];
                    q.push(xx * n + yy);
                }
            }
            for (int i = 1; i <= 4; i++) {
                if (i == next) continue;
                xx = x, yy = y;
                if (i == 1) yy++;
                if (i == 2) yy--;
                if (i == 3) xx++;
                if (i == 4) xx--;
                if (xx >= 0 && xx < m && yy >= 0 && yy < n) {
                    if (cost[x][y] + 1 < cost[xx][yy]) {
                        cost[xx][yy] = cost[x][y] + 1;
                        q.push(xx * n + yy);
                    }
                }
            }
        }
        return cost[m - 1][n - 1];
    }
};
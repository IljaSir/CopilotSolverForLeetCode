class Solution {
public:
    int minCost(vector<vector<int>>& grid) {
        
        int m = grid.size();
        int n = grid[0].size();
        vector<vector<int>> cost(m, vector<int>(n, INT_MAX));
        cost[0][0] = 0;
        queue<pair<int, int>> q;
        q.push(make_pair(0, 0));
        while (!q.empty()) {
            int x = q.front().first;
            int y = q.front().second;
            q.pop();
            if (x > 0 && cost[x][y] + (grid[x][y] == 1 ? 0 : 1) < cost[x - 1][y]) {
                cost[x - 1][y] = cost[x][y] + (grid[x][y] == 1 ? 0 : 1);
                q.push(make_pair(x - 1, y));
            }
            if (x < m - 1 && cost[x][y] + (grid[x][y] == 3 ? 0 : 1) < cost[x + 1][y]) {
                cost[x + 1][y] = cost[x][y] + (grid[x][y] == 3 ? 0 : 1);
                q.push(make_pair(x + 1, y));
            }
            if (y > 0 && cost[x][y] + (grid[x][y] == 2 ? 0 : 1) < cost[x][y - 1]) {
                cost[x][y - 1] = cost[x][y] + (grid[x][y] == 2 ? 0 : 1);
                q.push(make_pair(x, y - 1));
            }
            if (y < n - 1 && cost[x][y] + (grid[x][y] == 4 ? 0 : 1) < cost[x][y + 1]) {
                cost[x][y + 1] = cost[x][y] + (grid[x][y] == 4 ? 0 : 1);
                q.push(make_pair(x, y + 1));
            }
        }
        return cost[m - 1][n - 1];
    }
};
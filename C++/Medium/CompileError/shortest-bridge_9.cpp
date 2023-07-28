class Solution {
public:
    int shortestBridge(vector<vector<int>>& grid) {
        
        int n = grid.size();
        int m = grid[0].size();
        int i, j, k, l, x, y;
        int min = 999999;
        queue<pair<int, int>> q;
        queue<pair<int, int>> q1;
        queue<pair<int, int>> q2;
        bool found = false;
        for(i = 0; i < n; i++) {
            for(j = 0; j < m; j++) {
                if(grid[i][j] == 1) {
                    q.push({i, j});
                    found = true;
                    break;
                }
            }
            if(found) {
                break;
            }
        }
        found = false;
        while(!q.empty()) {
            auto p = q.front();
            q.pop();
            x = p.first;
            y = p.second;
            grid[x][y] = 2;
            if(x > 0 && grid[x-1][y] == 1) {
                q.push({x-1, y});
            }
            if(x < n-1 && grid[x+1][y] == 1) {
                q.push({x+1, y});
            }
            if(y > 0 && grid[x][y-1] == 1) {
                q.push({x, y-1});
            }
            if(y < m-1 && grid[x][y+1] == 1) {
                q.push({x, y+1});
            }
        }
        for(i = 0; i < n; i++) {
            for(j = 0; j < m; j++) {
                if(grid[i][j] == 1) {
                    q1.push({i, j});
                    found = true;
                    break;
                }
            }
            if(found) {
                break;
            }
        }
        while(!q1.empty()) {
            auto p = q1.front();
            q1.pop();
            x = p.first;
            y = p.second;
            if(x > 0 && grid[x-1][y] == 0) {
                grid[x-1][y] = 3;
                q2.push({x-1, y});
            }
            if(x < n-1 && grid[x+1][y] == 0) {
                grid[x+1][y] =
    }
};
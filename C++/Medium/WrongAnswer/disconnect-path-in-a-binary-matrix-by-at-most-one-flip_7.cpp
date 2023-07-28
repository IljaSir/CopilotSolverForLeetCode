class Solution {
public:
    bool isPossibleToCutPath(vector<vector<int>>& grid) {
        
        int m = grid.size();
        int n = grid[0].size();
        vector<vector<int>> count(m, vector<int>(n, 0));
        queue<pair<int, int>> q;
        q.push({0, 0});
        count[0][0] = 1;
        while(!q.empty()) {
            auto p = q.front();
            q.pop();
            int x = p.first;
            int y = p.second;
            if(x == m - 1 && y == n - 1) {
                return true;
            }
            if(x > 0 && grid[x - 1][y] == 1 && count[x - 1][y] == 0) {
                q.push({x - 1, y});
                count[x - 1][y] = 1;
            }
            if(y > 0 && grid[x][y - 1] == 1 && count[x][y - 1] == 0) {
                q.push({x, y - 1});
                count[x][y - 1] = 1;
            }
            if(x < m - 1 && grid[x + 1][y] == 1 && count[x + 1][y] == 0) {
                q.push({x + 1, y});
                count[x + 1][y] = 1;
            }
            if(y < n - 1 && grid[x][y + 1] == 1 && count[x][y + 1] == 0) {
                q.push({x, y + 1});
                count[x][y + 1] = 1;
            }
        }
        return false;
    }
    bool disconnectPathInMatrix(vector<vector<int>>& grid) {
        int m = grid.size();
        int n = grid[0].size();
        if(isPossibleToCutPath(grid)) {
            return true;
        }
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 1) {
                    grid[i][j] = 0;
                    if(!isPossibleToCutPath(grid)) {
                        return false;
                    }
                    grid[i][j] = 1;
                }
            }
        }
        return true;
    }
};
class Solution {
public:
    bool checkValidGrid(vector<vector<int>>& grid) {
        
        vector<vector<int>> dir = {{-2,-1}, {-2,1}, {-1,-2}, {-1,2}, {1,-2}, {1,2}, {2,-1}, {2,1}};
        int n = grid.size();
        int m = grid[0].size();
        int x = 0;
        int y = 0;
        for (int i = 0; i < n * m; i++) {
            bool found = false;
            for (int j = 0; j < 8; j++) {
                int x1 = x + dir[j][0];
                int y1 = y + dir[j][1];
                if (x1 >= 0 && x1 < n && y1 >= 0 && y1 < m && grid[x1][y1] == i + 1) {
                    found = true;
                    x = x1;
                    y = y1;
                    break;
                }
            }
            if (!found) {
                return false;
            }
        }
        return true;
    }
    bool checkValidKnightTour(vector<vector<int>>& grid) {
        int n = grid.size();
        int m = grid[0].size();
        if (grid[0][0] != 0) {
            return false;
        }
        vector<int> cnt(n * m, 0);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] >= n * m || grid[i][j] < 0) {
                    return false;
                }
                cnt[grid[i][j]]++;
            }
        }
        for (int i = 0; i < n * m; i++) {
            if (cnt[i] != 1) {
                return false;
            }
        }
        return checkValidGrid(grid);
    }
};
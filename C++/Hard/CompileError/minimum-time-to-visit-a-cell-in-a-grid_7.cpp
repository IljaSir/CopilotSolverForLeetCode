class Solution {
public:
    int minimumTime(vector<vector<int>>& grid) {
        
        int m = grid.size(), n = grid[0].size();
        int maxTime = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                maxTime = max(maxTime, grid[i][j]);
            }
        }
        int left = 0, right = maxTime;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (check(grid, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
};
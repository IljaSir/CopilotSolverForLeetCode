class Solution {
public:
    int countPyramids(vector<vector<int>>& grid) {
        
        int m = grid.size();
        int n = grid[0].size();
        int ans = 0;
        // pyramids
        for (int r = 0; r < m; ++r) {
            for (int c = 0; c < n; ++c) {
                int h = 1;
                while (r + h < m && c - h >= 0 && c + h < n && grid[r + h][c - h] && grid[r + h][c + h]) {
                    ++h;
                }
                if (h > 1) {
                    ans += h - 1;
                }
            }
        }
        // inverse pyramids
        for (int r = m - 1; r >= 0; --r) {
            for (int c = 0; c < n; ++c) {
                int h = 1;
                while (r - h >= 0 && c - h >= 0 && c + h < n && grid[r - h][c - h] && grid[r - h][c + h]) {
                    ++h;
                }
                if (h > 1) {
                    ans += h - 1;
                }
            }
        }
        return ans;
    }
};
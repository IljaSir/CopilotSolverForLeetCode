class Solution {
public:
    vector<int> maxPoints(vector<vector<int>>& grid, vector<int>& queries) {
        
        int m = grid.size(), n = grid[0].size();
        vector<int> ans(queries.size());
        for (int i = 0; i < m; ++i) {
            for (int j = 1; j < n; ++j) {
                grid[i][j] = max(grid[i][j], grid[i][j - 1]);
            }
        }
        for (int i = 1; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                grid[i][j] = max(grid[i][j], grid[i - 1][j]);
            }
        }
        for (int i = 0; i < queries.size(); ++i) {
            int q = queries[i];
            int l = 0, r = m * n;
            while (l < r) {
                int mid = l + (r - l) / 2;
                int x = mid / n, y = mid % n;
                if (grid[x][y] > q) {
                    r = mid;
                } else {
                    l = mid + 1;
                }
            }
            ans[i] = l;
        }
        return ans;
    }
};
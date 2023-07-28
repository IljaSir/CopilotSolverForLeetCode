class Solution {
public:
    int maxIncreaseKeepingSkyline(vector<vector<int>>& grid) {
        
        int n = grid.size();
        vector<int> top(n, 0), left(n, 0);
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                top[i] = max(top[i], grid[i][j]);
                left[j] = max(left[j], grid[i][j]);
            }
        }
        int res = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                res += min(top[i], left[j]) - grid[i][j];
            }
        }
        return res;
    }
};
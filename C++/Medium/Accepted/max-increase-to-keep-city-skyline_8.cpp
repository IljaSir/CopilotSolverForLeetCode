class Solution {
public:
    int maxIncreaseKeepingSkyline(vector<vector<int>>& grid) {
        
        int n = grid.size();
        vector<int> top(n, 0);
        vector<int> left(n, 0);
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                top[i] = max(top[i], grid[i][j]);
                left[j] = max(left[j], grid[i][j]);
            }
        }
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                ans += min(top[i], left[j]) - grid[i][j];
            }
        }
        return ans;
    }
};
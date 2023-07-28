class Solution {
public:
    vector<int> getBiggestThree(vector<vector<int>>& grid) {
        
        vector<int> ans;
        int m = grid.size();
        int n = grid[0].size();
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                for (int k = 1; k <= min(i, j) && k <= min(m - i - 1, n - j - 1); ++k) {
                    int sum = 0;
                    for (int d = 0; d <= k; ++d) {
                        sum += grid[i - d][j - k + d];
                        sum += grid[i + d][j + k - d];
                        sum += grid[i - k + d][j + d];
                        sum += grid[i + k - d][j - d];
                    }
                    ans.push_back(sum - grid[i][j]);
                }
            }
        }
        sort(ans.begin(), ans.end());
        ans.erase(unique(ans.begin(), ans.end()), ans.end());
        reverse(ans.begin(), ans.end());
        while (ans.size() > 3) ans.pop_back();
        return ans;
    }
};
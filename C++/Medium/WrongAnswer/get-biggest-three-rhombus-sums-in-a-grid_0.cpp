class Solution {
public:
    vector<int> getBiggestThree(vector<vector<int>>& grid) {
        
        int m = grid.size(), n = grid[0].size();
        vector<int> ans;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                for (int k = 0; k <= min(i, j) && k <= min(m - i - 1, n - j - 1); ++k) {
                    int sum = 0;
                    for (int t = 0; t <= k; ++t) {
                        sum += grid[i - t][j - t];
                        sum += grid[i + t][j + t];
                        sum += grid[i - t][j + t];
                        sum += grid[i + t][j - t];
                    }
                    ans.push_back(sum - grid[i][j]);
                }
            }
        }
        sort(ans.begin(), ans.end(), greater<int>());
        ans.erase(unique(ans.begin(), ans.end()), ans.end());
        return vector<int>(ans.begin(), ans.begin() + min((int)ans.size(), 3));
    }
};
class Solution {
public:
    vector<int> getBiggestThree(vector<vector<int>>& grid) {
        
        int m = grid.size();
        int n = grid[0].size();
        vector<int> ans;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                for (int k = 0; k <= min(i, j) && k <= min(m - 1 - i, n - 1 - j); ++k) {
                    int sum = 0;
                    for (int t = 0; t <= k; ++t) {
                        sum += grid[i - t][j - k + t];
                        sum += grid[i + t][j - k + t];
                        sum += grid[i - t][j + k - t];
                        sum += grid[i + t][j + k - t];
                    }
                    ans.push_back(sum - grid[i][j]);
                }
            }
        }
        sort(ans.begin(), ans.end(), greater<int>());
        ans.erase(unique(ans.begin(), ans.end()), ans.end());
        while (ans.size() > 3) ans.pop_back();
        return ans;
    }
};
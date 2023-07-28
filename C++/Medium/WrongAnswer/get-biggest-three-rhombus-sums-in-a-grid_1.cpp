class Solution {
public:
    vector<int> getBiggestThree(vector<vector<int>>& grid) {
        
        int m = grid.size();
        int n = grid[0].size();
        vector<int> res;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                int sum = 0;
                for (int k = 0; i - k >= 0 && j - k >= 0 && i + k < m && j + k < n; ++k) {
                    sum += grid[i - k][j - k] + grid[i - k][j + k] + grid[i + k][j - k] + grid[i + k][j + k];
                    if (k > 0) {
                        sum -= grid[i - k + 1][j - k] + grid[i - k + 1][j + k] + grid[i + k - 1][j - k] + grid[i + k - 1][j + k];
                    }
                    res.push_back(sum);
                }
            }
        }
        sort(res.begin(), res.end(), greater<int>());
        res.erase(unique(res.begin(), res.end()), res.end());
        return vector<int>(res.begin(), res.begin() + min(3, (int)res.size()));
    }
};
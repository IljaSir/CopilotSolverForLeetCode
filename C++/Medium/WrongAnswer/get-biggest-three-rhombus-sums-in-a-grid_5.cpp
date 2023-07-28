class Solution {
public:
    vector<int> getBiggestThree(vector<vector<int>>& grid) {
        
        vector<int> res;
        int m = grid.size();
        int n = grid[0].size();
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                int sum = 0;
                for (int k = 0; i - k >= 0 && i + k < m && j - k >= 0 && j + k < n; ++k) {
                    sum += grid[i - k][j];
                    sum += grid[i + k][j];
                    sum += grid[i][j - k];
                    sum += grid[i][j + k];
                    if (k > 0) {
                        sum -= grid[i - k][j - k];
                        sum -= grid[i - k][j + k];
                        sum -= grid[i + k][j - k];
                        sum -= grid[i + k][j + k];
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
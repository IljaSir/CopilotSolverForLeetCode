class Solution {
public:
    vector<int> getBiggestThree(vector<vector<int>>& grid) {
        
        int m = grid.size();
        int n = grid[0].size();
        vector<int> res;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                int k = 1;
                while (i - k >= 0 && i + k < m && j - k >= 0 && j + k < n) {
                    int sum = grid[i][j];
                    for (int l = 1; l <= k; ++l) {
                        sum += grid[i - l][j + l] + grid[i - l][j - l] + grid[i + l][j + l] + grid[i + l][j - l];
                    }
                    res.push_back(sum);
                    ++k;
                }
            }
        }
        sort(res.begin(), res.end());
        res.erase(unique(res.begin(), res.end()), res.end());
        if (res.size() > 3) {
            res.erase(res.begin(), res.end() - 3);
        }
        return res;
    }
};
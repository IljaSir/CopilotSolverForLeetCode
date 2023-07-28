class Solution {
public:
    vector<int> getBiggestThree(vector<vector<int>>& grid) {
        
        int n = grid.size();
        int m = grid[0].size();
        set<int> res;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                int k = 0;
                while (i + k < n && i - k >= 0 && j + k < m && j - k >= 0) {
                    int sum = 0;
                    for (int c = j - k; c <= j + k; ++c) {
                        sum += grid[i - k][c];
                        sum += grid[i + k][c];
                    }
                    for (int r = i - k + 1; r <= i + k - 1; ++r) {
                        sum += grid[r][j - k];
                        sum += grid[r][j + k];
                    }
                    res.insert(sum);
                    if (res.size() > 3) res.erase(res.begin());
                    ++k;
                }
            }
        }
        return vector<int>(res.rbegin(), res.rend());
    }
};
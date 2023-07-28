class Solution {
public:
    int matrixScore(vector<vector<int>>& grid) {
        
        int m = grid.size();
        int n = grid[0].size();
        int sum = 0;
        for (int i = 0; i < m; ++i) {
            if (grid[i][0] == 0) {
                for (int j = 0; j < n; ++j) {
                    grid[i][j] = 1 - grid[i][j];
                }
            }
        }
        for (int j = 1; j < n; ++j) {
            int cnt = 0;
            for (int i = 0; i < m; ++i) {
                if (grid[i][j] == 1) {
                    ++cnt;
                }
            }
            if (cnt < m - cnt) {
                cnt = m - cnt;
            }
            sum += cnt * (1 << (n - j - 1));
        }
        sum += m * (1 << (n - 1));
        return sum;
    }
};
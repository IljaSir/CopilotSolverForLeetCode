class Solution {
public:
    int maxSum(vector<vector<int>>& grid) {
        
        int m = grid.size(), n = grid[0].size();
        int res = INT_MIN;
        for (int i = 0; i < m - 2; i++) {
            for (int j = 0; j < n - 2; j++) {
                int sum = 0;
                for (int k = 0; k < 3; k++) {
                    sum += grid[i][j + k];
                    sum += grid[i + 2][j + k];
                }
                sum += grid[i + 1][j + 1];
                res = max(res, sum);
            }
        }
        return res;
    }
};
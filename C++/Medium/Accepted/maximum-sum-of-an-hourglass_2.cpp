class Solution {
public:
    int maxSum(vector<vector<int>>& grid) {
        
        int m = grid.size();
        int n = grid[0].size();
        int maxSum = INT_MIN;
        for(int i = 0; i < m - 2; i++) {
            for(int j = 0; j < n - 2; j++) {
                int sum = 0;
                sum += grid[i][j];
                sum += grid[i][j + 1];
                sum += grid[i][j + 2];
                sum += grid[i + 1][j + 1];
                sum += grid[i + 2][j];
                sum += grid[i + 2][j + 1];
                sum += grid[i + 2][j + 2];
                maxSum = max(maxSum, sum);
            }
        }
        return maxSum;
    }
};
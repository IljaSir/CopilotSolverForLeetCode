class Solution {
public:
    int maxSum(vector<vector<int>>& grid) {
        
        int sum = 0;
        int maxSum = INT_MIN;
        for (int i = 0; i < grid.size() - 2; i++) {
            for (int j = 0; j < grid[i].size() - 2; j++) {
                sum = 0;
                sum += grid[i][j] + grid[i][j+1] + grid[i][j+2];
                sum += grid[i+1][j+1];
                sum += grid[i+2][j] + grid[i+2][j+1] + grid[i+2][j+2];
                maxSum = max(maxSum, sum);
            }
        }
        return maxSum;
    }
};
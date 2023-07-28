class Solution {
public:
    int uniquePathsWithObstacles(vector<vector<int>>& obstacleGrid) {
        
        int m = obstacleGrid.size(), n = obstacleGrid[0].size();
        vector<vector<int>> dp(m, vector<int>(n, 0));
        dp[0][0] = 1 - obstacleGrid[0][0];
       for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i  1][0] *( - obstacleGrid[i][0)
    }
};
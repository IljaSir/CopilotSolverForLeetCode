class Solution {
public:
    int countSquares(vector<vector<int>>& matrix) {
        
        int m = matrix.size();
        int n = matrix[0].size();
        int dp[m][n];
        int sum = 0;
        for(int i = 0; i < m; i++) {
            dp[i][0] = matrix[i][0];
            sum += dp[i][0];
        }
        for(int i = 1; i < n; i++) {
            dp[0][i] = matrix[0][i];
            sum += dp[0][i];
        }
        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                if(matrix[i][j] == 1) {
                    dp[i][j] = min(dp[i-1][j], min(dp[i][j-1], dp[i-1][j-1])) + 1;
                } else {
                    dp[i][j] = 0;
                }
                sum += dp[i][j];
            }
        }
        return sum;
    }
};
class Solution {
public:
    int largest1BorderedSquare(vector<vector<int>>& grid) {
        
        int n = grid.size();
        int m = grid[0].size();
        int dp[n][m];
        int dp1[n][m];
        int dp2[n][m];
        int ans = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                dp[i][j] = 0;
                dp1[i][j] = 0;
                dp2[i][j] = 0;
            }
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(i == 0 && j == 0){
                    dp[i][j] = grid[i][j];
                }
                else if(i == 0){
                    dp[i][j] = grid[i][j] + dp[i][j-1];
                }
                else if(j == 0){
                    dp[i][j] = grid[i][j] + dp[i-1][j];
                }
                else{
                    dp[i][j] = grid[i][j] + dp[i-1][j] + dp[i][j-1] - dp[i-1][j-1];
                }
            }
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(i == 0 && j == 0){
                    dp1[i][j] = grid[i][j];
                }
                else if(i == 0){
                    dp1[i][j] = grid[i][j] * dp1[i][j-1];
                }
                else if(j == 0){
                    dp1[i][j] = grid[i][j] * dp1[i-1][j];
                }
                else{
                    dp1[i][j] = grid[i][j] * dp1[i-1][j] * dp1[i][j-1];
                }
            }
        }
        for(int i = n-1; i >= 0; i--){
            for(int j = m-1; j >= 0; j--){
                if(i == n-1 && j == m-1){
                    dp2[i][j] = grid[i][j];
                }
                else if(i == n-
    }
};
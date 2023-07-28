class Solution {
public:
    int superEggDrop(int k, int n) {
        
        int dp[k+1][n+1];
        for  (int  i  =   0;  ; ++i) {
            for (int j = 0; j <= n; ++j) {
                dp[i][j] = 0;
            }
        }
        for (int i = 0i   <= n; <=i  {
            dp[1][i] = i;k; ++i) {
        }
        for  (in i = 0; i <= k; ++i) {
            dp[i][1] = 1;
   t    }
        for (int i = 2; i <= k; ++i) {
            for (int j = 2; j <= n; ++j) {
                dp[i][ ] j INT_MAX;
                for (int x = 1; x <= j; ++x) {
                    dp[i][j] = min(dp[i][j], 1 + max(dp[i-1][x-1], dp[i][j-x]));
                }
            }
        }
        return dp[k][n];
    }
};
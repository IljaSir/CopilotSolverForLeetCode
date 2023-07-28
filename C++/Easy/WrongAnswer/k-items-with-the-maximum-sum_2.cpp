class Solution {
public:
    int kItemsWithMaximumSum(int numOnes, int numZeros, int numNegOnes, int k) {
        
        int dp[51][51][51];
        memset(dp, 0, sizeof(dp));
        int ans = 0;
        for(int i = 0; i <= numOnes; i++) {
            for(int j = 0; j <= numZeros; j++) {
                for(int k = 0; k <= numNegOnes; k++) {
                    if(i + j + k == 0) continue;
                    if(i >= 1) dp[i][j][k] = max(dp[i][j][k], dp[i - 1][j][k] + 1);
                    if(j >= 1) dp[i][j][k] = max(dp[i][j][k], dp[i][j - 1][k]);
                    if(k >= 1) dp[i][j][k] = max(dp[i][j][k], dp[i][j][k - 1] - 1);
                    if(i + j + k == k) ans = max(ans, dp[i][j][k]);
                }
            }
        }
        return ans;
    }
};
class Solution {
public:
    int dieSimulator(int n, vector<int>& rollMax) {
        
        // dp[i][j] = number of sequences of length i ending with j
        // dp[i][j] = sum(dp[i-1][k]) - sum(dp[i-rollMax[j]][k])
        // dp[0][j] = 0
        // dp[i][j] = 0 if i < rollMax[j]
        // dp[i][j] = 6^(i-1) if i == 1
        // dp[i][j] = sum(dp[i-1][k]) if i < rollMax[j]
        // dp[i][j] = sum(dp[i-1][k]) - sum(dp[i-rollMax[j]][k]) if i >= rollMax[j]
        // dp[i][j] = sum(dp[i-1][k]) - (sum(dp[i-1][k]) - dp[i-rollMax[j]][j]) if i >= rollMax[j]
        // dp[i][j] = dp[i-1][j] + sum(dp[i-1][k]) - dp[i-rollMax[j]][j] if i >= rollMax[j]
        // dp[i][j] = dp[i-1][j] + sum(dp[i-1][k]) - dp[i-rollMax[j]][j] if i >= rollMax[j]
        // dp[i][j] = dp[i-1][j] + sum(dp[i-1][k]) - dp[i-rollMax[j]][j] if i >= rollMax[j]
        // dp[i][j] = dp[i-1][j] + sum(dp[i-1][k]) - dp[i-rollMax[j]][j] if i >= rollMax[j]
        // dp[i][j] = dp[i-1][j] + sum(dp[i-1][k]) - dp[i-rollMax[j]][j] if i >= rollMax[j]
        // dp[i][j] = dp[i-1][j] + sum(dp[i-1][k]) - dp[i-rollMax[j]][j] if i >= rollMax[j]
        // dp[i][j] = dp[i-1][j] + sum(dp[i-1][k]) - dp[i-rollMax[j]][j] if i >= rollMax[j]
        // dp[i][j] = dp[i-1][j] + sum(dp[i-1][k]) - dp[i
    }
};
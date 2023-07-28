class Solution {
public:
    int stoneGameV(vector<int>& stoneValue) {
        
        int n = stoneValue.size();
        vector<int> prefix(n + 1);
        for (int i = 0; i < n; ++i) {
            prefix[i + 1] = prefix[i] + stoneValue[i];
        }
        vector<vector<int>> dp(n, vector<int>(n));
        for (int i = 0; i < n; ++i) {
            for (int j = i; j < n; ++j) {
                if (i == j) {
                    dp[i][j] = 0;
                } else {
                    int sum = prefix[j + 1] - prefix[i];
                    for (int k = i; k < j; ++k) {
                        int left = prefix[k + 1] - prefix[i];
                        int right = sum - left;
                        if (left < right) {
                            dp[i][j] = max(dp[i][j], dp[i][k] + left);
                        } else if (left > right) {
                            dp[i][j] = max(dp[i][j], dp[k + 1][j] + right);
                        } else {
                            dp[i][j] = max(dp[i][j], max(dp[i][k], dp[k + 1][j]) + left);
                        }
                    }
                }
            }
        }
        return dp[0][n - 1];
    }
};
class Solution {
public:
    int numOfWays(vector<int>& nums) {
        
        int n = nums.size();
        vector<vector<int>> dp(n, vector<int>(n, 0));
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }
        for (int i = 0; i < n - 1; i++) {
            dp[i][i + 1] = 1;
            dp[i + 1][i] = 1;
        }
        for (int len = 2; len < n; len++) {
            for (int i = 0; i < n - len; i++) {
                int j = i + len;
                for (int k = i + 1; k <= j; k++) {
                    if (nums[k] < nums[i]) {
                        dp[i][j] += dp[i + 1][k - 1] * dp[k][j];
                    } else if (nums[k] > nums[j]) {
                        dp[i][j] += dp[i][k - 1] * dp[k][j - 1];
                    } else {
                        dp[i][j] += dp[i][k - 1] * dp[k][j] + dp[i + 1][k - 1] * dp[k][j - 1];
                    }
                    dp[i][j] %= 1000000007;
                }
            }
        }
        return dp[0][n - 1] - 1;
    }
};
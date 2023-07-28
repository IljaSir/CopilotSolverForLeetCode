class Solution {
public:
    int numOfWays(vector<int>& nums) {
        
        int M = 1000000007;
        int n = nums.size();
        if (n < 3) return 0;
        vector<vector<int>> dp(n, vector<int>(n, 0));
        for (int i = 0; i < n; ++i) {
            dp[i][i] = 1;
        }
        for (int len = 2; len <= n; ++len) {
            for (int i = 0; i + len <= n; ++i) {
                int j = i + len - 1;
                for (int k = i + 1; k <= j; ++k) {
                    if (nums[k] > nums[i]) {
                        dp[i][j] += (long) dp[i + 1][k - 1] * dp[k][j] % M;
                        dp[i][j] %= M;
                    }
                    if (nums[k] < nums[j]) {
                        dp[i][j] += (long) dp[i][k - 1] * dp[k][j - 1] % M;
                        dp[i][j] %= M;
                    }
                }
            }
        }
        return (dp[0][n - 1] - 1 + M) % M;
    }
};
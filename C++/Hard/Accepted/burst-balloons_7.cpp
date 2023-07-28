class Solution {
public:
    int maxCoins(vector<int>& nums) {
        
        int n = nums.size();
        int dp[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = 0;
            }
        }
        for (int k = 1; k <= n; k++) {
            for (int i = 0; i < n - k + 1; i++) {
                int j = i + k - 1;
                for (int x = i; x <= j; x++) {
                    int left = 1, right = 1;
                    if (i != 0) {
                        left = nums[i - 1];
                    }
                    if (j != n - 1) {
                        right = nums[j + 1];
                    }
                    int before = 0, after = 0;
                    if (i != x) {
                        before = dp[i][x - 1];
                    }
                    if (j != x) {
                        after = dp[x + 1][j];
                    }
                    dp[i][j] = max(dp[i][j], before + left * nums[x] * right + after);
                }
            }
        }
        return dp[0][n - 1];
    }
};
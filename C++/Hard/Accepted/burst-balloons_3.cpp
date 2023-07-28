class Solution {
public:
    int maxCoins(vector<int>& nums) {
        
        int n = nums.size();
        vector<int> a(n + 2);
        a[0] = a[n + 1] = 1;
        for (int i = 0; i < n; ++i) {
            a[i + 1] = nums[i];
        }

        vector<vector<int>> dp(n + 2, vector<int>(n + 2));
        for (int len = 1; len <= n; ++len) {
            for (int left = 1; left <= n - len + 1; ++left) {
                int right = left + len - 1;
                for (int i = left; i <= right; ++i) {
                    dp[left][right] = max(dp[left][right],
                        a[left - 1] * a[i] * a[right + 1] + dp[left][i - 1] + dp[i + 1][right]);
                }
            }
        }
        return dp[1][n];
    }
};
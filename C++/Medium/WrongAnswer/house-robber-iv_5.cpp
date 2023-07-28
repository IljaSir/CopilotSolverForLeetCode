class Solution {
public:
    int minCapability(vector<int>& nums, int k) {
        
        int n = nums.size();
        if (n < k) return 0;
        if (n == k) return *max_element(nums.begin(), nums.end());
        vector<vector<int>> dp(n, vector<int>(k + 1, INT_MAX));
        for (int i = 0; i < n; i++) {
            dp[i][1] = max(nums[i], i > 0 ? dp[i - 1][1] : 0);
            for (int j = 2; j <= k; j++) {
                for (int l = i - 1; l >= j - 2; l--) {
                    if (l >= 0) {
                        dp[i][j] = min(dp[i][j], max(dp[l][j - 1], nums[i]));
                    } else {
                        dp[i][j] = min(dp[i][j], nums[i]);
                    }
                }
            }
        }
        return dp[n - 1][k];
    }
};
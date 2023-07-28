class Solution {
public:
    int minCapability(vector<int>& nums, int k) {
        
        int n = nums.size();
        if (n == 1) return nums[0];
        if (k == 1) return max(nums[0], nums[n-1]);
        vector<vector<int>> dp(n, vector<int>(n, 0));
        for (int i = 0; i < n; i++) {
            int minNum = nums[i];
            for (int j = i; j < n; j++) {
                minNum = min(minNum, nums[j]);
                dp[i][j] = minNum;
            }
        }
        vector<int> f(n);
        for (int i = 0; i < n; i++) {
            f[i] = dp[0][i];
        }
        for (int i = 2; i <= k; i++) {
            vector<int> g(n);
            for (int j = i-1; j < n; j++) {
                g[j] = f[j-1] + dp[j][n-1];
                for (int k = j-1; k >= i-1; k--) {
                    g[j] = min(g[j], f[k-1] + dp[k][j]);
                }
            }
            f = g;
        }
        return f[n-1];
    }
};
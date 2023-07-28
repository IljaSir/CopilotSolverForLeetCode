class Solution {
public:
    int minCapability(vector<int>& nums, int k) {
        
        int n = nums.size();
        int dp[n][k+1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= k; j++) {
                dp[i][j] = 0;
            }
        }
        for (int i = 0; i < n; i++) {
            dp[i][1] = nums[i];
        }
        for (int i = 0; i < n; i++) {
            for (int j = 2; j <= k; j++) {
                int m = INT_MAX;
                for (int p = 0; p < i; p++) {
                    m = min(m, max(dp[p][j-1], nums[i]));
                }
                dp[i][j] = m;
            }
        }
        int m = INT_MAX;
        for (int i = 0; i < n; i++) {
            m = min(m, dp[i][k]);
        }
        return m;
    }
};
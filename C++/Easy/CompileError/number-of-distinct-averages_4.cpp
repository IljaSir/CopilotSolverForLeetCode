class Solution {
public:
    int distinctAverages(vector<int>& nums) {
        
        int n = nums.size();
        int m = n / 2;
        int maxn = 100;
        vector<vector<bool>> dp(m + 1, vector<bool>(maxn * m + 1, false));
        dp[0][0] = true;
        for (int i = 0; i < n; i++) {
            for (int j = m; j >= 1; j--) {
                for (int k = maxn * m; k >= nums[i]; k--) {
                    dp[j][k] |= dp[j - 1][k - nums[i]];
                }
            }
        }
        int ans = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= maxn * m; j++) {
                if (dp[i][j]) {
                    ans++;
                }
            }
        }
        return ans;
    }
};
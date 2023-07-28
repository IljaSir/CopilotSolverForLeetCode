class Solution {
public:
    int longestArithSeqLength(vector<int>& nums) {
        
        int n = nums.size();
        vector<vector<int>> dp(n, vector<int>(n, 2));
        int ans = 2;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = 0; k < i; k++) {
                    if (nums[i] - nums[k] == nums[j] - nums[i]) {
                        dp[i][j] = dp[k][i] + 1;
                        ans = max(ans, dp[i][j]);
                    }
                }
            }
        }
        return ans;
    }
};
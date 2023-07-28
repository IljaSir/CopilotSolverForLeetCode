class Solution {
public:
    int longestArithSeqLength(vector<int>& nums) {
        
        int n = nums.size();
        int dp[n][n];
        memset(dp, 0, sizeof(dp));
        int ans = 2;
        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                int target = 2 * nums[i] - nums[j];
                dp[i][j] = 2;
                for(int k = i - 1; k >= 0; k--) {
                    if(nums[k] == target) {
                        dp[i][j] = max(dp[i][j], dp[k][i] + 1);
                    }
                }
                ans = max(ans, dp[i][j]);
            }
        }
        return ans;
    }
};
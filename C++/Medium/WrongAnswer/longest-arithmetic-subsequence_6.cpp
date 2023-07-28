class Solution {
public:
    int longestArithSeqLength(vector<int>& nums) {
        
        int n = nums.size();
        vector<vector<int>> dp(n, vector<int>(n, 1));
        int res = 1;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int d = nums[j] - nums[i];
                for (int k = i - 1; k >= 0; k--) {
                    if (nums[i] - nums[k] == d) {
                        dp[i][j] = dp[k][i] + 1;
                        break;
                    }
                }
                res = max(res, dp[i][j]);
            }
        }
        return res;
    }
};
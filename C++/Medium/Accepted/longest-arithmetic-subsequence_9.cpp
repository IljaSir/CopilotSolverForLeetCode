class Solution {
public:
    int longestArithSeqLength(vector<int>& nums) {
        
        int n = nums.size();
        int dp[n][1001];
        memset(dp, 0, sizeof(dp));
        int max_len = 0;
        for (int i = 1; i < n; ++i) {
            for (int j = 0; j < i; ++j) {
                int diff = nums[i] - nums[j] + 500;
                dp[i][diff] = max(dp[i][diff], dp[j][diff] + 1);
                max_len = max(max_len, dp[i][diff]);
            }
        }
        return max_len + 1;
    }
};
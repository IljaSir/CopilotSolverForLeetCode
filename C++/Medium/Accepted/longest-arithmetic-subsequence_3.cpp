class Solution {
public:
    int longestArithSeqLength(vector<int>& nums) {
        
        int n = nums.size();
        int dp[n][1001];
        memset(dp, 0, sizeof(dp));
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int diff = nums[j] - nums[i] + 500;
                dp[j][diff] = max(dp[j][diff], dp[i][diff] + 1);
                ans = max(ans, dp[j][diff] + 1);
            }
        }
        return ans;
    }
};
class Solution {
public:
    int maxSumDivThree(vector<int>& nums) {
        
        int dp[3] = {0};
        for (int i = 0; i < nums.size(); i++) {
            int dp2[3] = {0};
            for (int j = 0; j < 3; j++) {
                dp2[(nums[i] + j) % 3] = max(dp2[(nums[i] + j) % 3], dp[j] + nums[i]);
            }
            for (int j = 0; j < 3; j++) {
                dp[j] = max(dp[j], dp2[j]);
            }
        }
        return dp[0];
    }
};
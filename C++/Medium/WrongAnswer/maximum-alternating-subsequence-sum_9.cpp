class Solution {
public:
    long long maxAlternatingSum(vector<int>& nums) {
        
        long long dp[2] = {0, 0};
        for (int i = 0; i < nums.size(); i++) {
            dp[i % 2] = max(dp[i % 2], dp[(i + 1) % 2] + nums[i]);
        }
        return max(dp[0], dp[1]);
    }
};
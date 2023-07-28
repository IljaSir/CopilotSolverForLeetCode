class Solution {
public:
    int countSpecialSubsequences(vector<int>& nums) {
        
        const int mod = 1e9 + 7;
        long long dp[3] = {0};
        for (int i = 0; i < nums.size(); i++) {
            dp[nums[i]] = (dp[nums[i]] + dp[nums[i]] + (nums[i] == 0 ? 1 : 0)) % mod;
        }
        return dp[2];
    }
};
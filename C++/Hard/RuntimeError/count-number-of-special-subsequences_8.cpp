class Solution {
public:
    int countSpecialSubsequences(vector<int>& nums) {
        
        int n = nums.size();
        long long int dp[3] = {0};
        for(int i = 0; i < n; i++) {
            dp[nums[i]] = dp[nums[i]] + 1 + dp[nums[i] - 1];
            dp[nums[i]] %= 1000000007;
        }
        return dp[2];
    }
};
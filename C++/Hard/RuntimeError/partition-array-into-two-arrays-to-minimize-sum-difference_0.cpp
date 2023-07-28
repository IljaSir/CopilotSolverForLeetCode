class Solution {
public:
    int minimumDifference(vector<int>& nums) {
        
        int n = nums.size() / 2;
        int sum = accumulate(nums.begin(), nums.end(), 0);
        vector<bool> dp(sum + 1, false);
        dp[0] = true;
        for (int i = 0; i < nums.size(); ++i) {
            for (int j = sum; j >= nums[i]; --j) {
                dp[j] = dp[j] || dp[j - nums[i]];
            }
        }
        int res = INT_MAX;
        for (int i = 0; i <= sum; ++i) {
            if (dp[i]) {
                res = min(res, abs(sum - 2 * i));
            }
        }
        return res;
    }
};
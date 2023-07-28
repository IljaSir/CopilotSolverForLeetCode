class Solution {
public:
    int minimumDifference(vector<int>& nums) {
        
        int n = nums.size();
        int sum = 0;
        for (int i = 0; i < n; ++i) {
            sum += nums[i];
        }
        int target = sum / 2;
        vector<int> dp(target + 1, 0);
        for (int i = 0; i < n; ++i) {
            for (int j = target; j >= nums[i]; --j) {
                dp[j] = max(dp[j], dp[j - nums[i]] + nums[i]);
            }
        }
        return sum - 2 * dp[target];
    }
};
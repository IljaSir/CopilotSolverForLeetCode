class Solution {
public:
    int minimumDifference(vector<int>& nums) {
        
        int n = nums.size();
        int n2 = n / 2;
        int sum = 0;
        for (int i = 0; i < n; ++i) {
            sum += nums[i];
        }
        int half = sum / 2;
        vector<int> dp(half + 1, 0);
        for (int i = 0; i < n2; ++i) {
            for (int j = half; j >= nums[i]; --j) {
                dp[j] = max(dp[j], dp[j - nums[i]] + nums[i]);
            }
        }
        int ans = sum - dp[half] - dp[half];
        for (int i = n2; i < n; ++i) {
            for (int j = half; j >= nums[i]; --j) {
                dp[j] = max(dp[j], dp[j - nums[i]] + nums[i]);
            }
            ans = min(ans, sum - dp[half] - dp[half]);
        }
        return ans;
    }
};
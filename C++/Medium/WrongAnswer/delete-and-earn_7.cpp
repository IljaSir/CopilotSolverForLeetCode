class Solution {
public:
    int deleteAndEarn(vector<int>& nums) {
        
        int n = nums.size();
        if (n == 0) return 0;
        if (n == 1) return nums[0];
        sort(nums.begin(), nums.end());
        int dp[n];
        dp[0] = nums[0];
        int i = 1;
        while (i < n && nums[i] == nums[i - 1]) {
            dp[i] = dp[i - 1] + nums[i];
            i++;
        }
        if (i == n) return dp[n - 1];
        dp[i] = max(dp[i - 1], nums[i]);
        for (int j = i + 1; j < n; j++) {
            if (nums[j] == nums[j - 1]) {
                dp[j] = dp[j - 1] + nums[j];
            } else if (nums[j] == nums[j - 1] + 1) {
                dp[j] = max(dp[j - 1], dp[j - 2] + nums[j]);
            } else {
                dp[j] = dp[j - 1] + nums[j];
            }
        }
        return dp[n - 1];
    }
};
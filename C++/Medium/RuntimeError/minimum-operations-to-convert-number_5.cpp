class Solution {
public:
    int minimumOperations(vector<int>& nums, int start, int goal) {
        
        int n = nums.size();
        int sum = start;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }
        int diff = abs(goal - sum);
        if (diff % 2 == 1) {
            return -1;
        }
        int target = diff / 2;
        vector<int> dp(target + 1, 0);
        for (int i = 1; i <= target; i++) {
            dp[i] = INT_MAX;
            for (int j = 0; j < n; j++) {
                if (i >= nums[j]) {
                    dp[i] = min(dp[i], dp[i - nums[j]] + 1);
                }
            }
        }
        return dp[target];
    }
};
class Solution {
public:
    int findTargetSumWays(vector<int>& nums, int target) {
        
        int n = nums.size();
        if (n == 0) return 0;
        int sum = 0;
        for (auto v : nums) sum += v;
        if (sum < target || (sum + target) % 2 == 1) return 0;
        int neg = (sum - target) / 2;
        vector<int> dp(neg + 1);
        dp[0] = 1;
        for (auto v : nums) {
            for (int i = neg; i >= v; i--) {
                dp[i] += dp[i - v];
            }
        }
        return dp[neg];
    }
};
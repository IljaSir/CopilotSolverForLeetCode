class Solution {
public:
    int arithmeticTriplets(vector<int>& nums, int diff) {
        
        int n = nums.size(), ans = 0;
        vector<int> dp(n, 0);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] - nums[j] == diff) {
                    dp[i] += dp[j] + 1;
                }
            }
            ans += dp[i];
        }
        return ans;
    }
};
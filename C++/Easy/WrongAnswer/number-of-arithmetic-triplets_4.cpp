class Solution {
public:
    int arithmeticTriplets(vector<int>& nums, int diff) {
        
        int n = nums.size();
        vector<int> dp(n, 0);
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = i - 1; j >= 0; --j) {
                if (nums[i] - nums[j] == diff) {
                    dp[i] += 1 + dp[j];
                    ans += dp[j];
                }
            }
        }
        return ans;
    }
};
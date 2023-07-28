class Solution {
public:
    int countMaxOrSubsets(vector<int>& nums) {
        
        int n = nums.size();
        vector<int> dp(1 << n, 0);
        for (int i = 0; i < n; ++i) {
            for (int j = (1 << n) - 1; j >= 0; --j) {
                if (j & (1 << i)) {
                    dp[j] = max(dp[j ^ (1 << i)] | nums[i], dp[j]);
                }
            }
        }
        int maxOr = *max_element(dp.begin(), dp.end());
        int ans = 0;
        for (int i = 0; i < (1 << n); ++i) {
            if (dp[i] == maxOr) {
                ++ans;
            }
        }
        return ans;
    }
};
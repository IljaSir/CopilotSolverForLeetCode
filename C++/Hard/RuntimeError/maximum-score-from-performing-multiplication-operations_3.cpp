class Solution {
public:
    int maximumScore(vector<int>& nums, vector<int>& multipliers) {
        
        int n = nums.size(), m = multipliers.size();
        vector<int> dp(m+1, INT_MIN);
        dp[0] = 0;
        for (int i = 1; i <= m; ++i) {
            for (int j = max(0, i-n); j <= min(i, m); ++j) {
                dp[j] = max(dp[j], dp[j-1]) + (j == 0 ? 0 : multipliers[i-1] * nums[j-1]);
                if (j < i) {
                    dp[j] = max(dp[j], dp[j] + multipliers[i-1] * nums[n-(i-j)]);
                }
            }
        }
        return *max_element(dp.begin(), dp.end());
    }
};
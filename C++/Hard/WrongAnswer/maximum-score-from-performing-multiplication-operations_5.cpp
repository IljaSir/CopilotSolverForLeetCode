class Solution {
public:
    int maximumScore(vector<int>& nums, vector<int>& multipliers) {
        
        int n = nums.size(), m = multipliers.size();
        vector<int> dp(m + 1);
        for (int i = 1; i <= m; ++i) {
            for (int j = max(0, i - n); j <= min(i, m); ++j) {
                int k = i - j;
                dp[j] = max(j > 0 ? dp[j - 1] + nums[j - 1] * multipliers[i - 1] : INT_MIN,
                            k > 0 ? dp[j] + nums[n - k] * multipliers[i - 1] : INT_MIN);
            }
        }
        return *max_element(dp.begin(), dp.end());
    }
};
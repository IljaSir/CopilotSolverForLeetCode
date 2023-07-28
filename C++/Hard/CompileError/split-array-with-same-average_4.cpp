class Solution {
public:
    bool splitArraySameAverage(vector<int>& nums) {
        
        int n = nums.size();
        int sum = accumulate(nums.begin(), nums.end(), 0);
        vector<vector<bool>> dp(n + 1, vector<bool>(n * 500 + 1, false));
        dp[0][0] = true;
        for (int i = 0; i < n; ++i) {
            for (int j = i; j >= 0; --j) {
                for (int k = n * 500; k >= nums[i]; --k) {
                    dp[j + 1][k] |= dp[j][k - nums[i]];
                }
            }
        }
        for (int i = 1; i < n; ++i) {
            if (sum * i % n == 0 && dp[i][sum * i / n]) {
                return true;
            }
        }
        return false;
    }
};
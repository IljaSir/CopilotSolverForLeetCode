class Solution {
public:
    bool splitArraySameAverage(vector<int>& nums) {
        
        int sum = accumulate(nums.begin(), nums.end(), 0);
        int n = nums.size();
        int half = n / 2;
        bool possible = false;
        for (int i = 1; i <= half; ++i) {
            if (sum * i % n == 0) {
                possible = true;
                break;
            }
        }
        if (!possible) return false;
        vector<vector<bool>> dp(n + 1, vector<bool>(sum + 1, false));
        dp[0][0] = true;
        for (int i = 1; i <= n; ++i) {
            for (int j = 0; j <= sum; ++j) {
                dp[i][j] = dp[i - 1][j];
                if (j >= nums[i - 1]) {
                    dp[i][j] = dp[i][j] || dp[i - 1][j - nums[i - 1]];
                }
            }
        }
        for (int i = 1; i <= half; ++i) {
            if (sum * i % n == 0 && dp[n][sum * i / n]) return true;
        }
        return false;
    }
};
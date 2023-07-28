class Solution {
public:
    bool splitArraySameAverage(vector<int>& nums) {
        
        int n = nums.size();
        int sum = accumulate(nums.begin(), nums.end(), 0);
        int maxLen = n/2;
        vector<vector<bool>> dp(maxLen+1, vector<bool>(sum+1, false));
        for (int i = 0; i < n; i++) {
            for (int j = maxLen; j >= 1; j--) {
                for (int k = sum; k >= nums[i]; k--) {
                    if (j == 1 && k == nums[i]) {
                        dp[j][k] = true;
                    } else if (j > 1 && dp[j-1][k-nums[i]]) {
                        dp[j][k] = true;
                    }
                }
            }
        }
        for (int i = 1; i <= maxLen; i++) {
            if (sum*i%n == 0 && dp[i][sum*i/n]) {
                return true;
            }
        }
        return false;
    }
};
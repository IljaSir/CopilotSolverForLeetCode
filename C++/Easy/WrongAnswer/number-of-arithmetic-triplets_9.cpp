class Solution {
public:
    int arithmeticTriplets(vector<int>& nums, int diff) {
        
        int count = 0;
        vector<vector<int>> dp(nums.size(), vector<int>(nums.size(), 0));
        for (int i = 0; i < nums.size(); i++) {
            for (int j = i + 1; j < nums.size(); j++) {
                if (nums[j] - nums[i] == diff) {
                    dp[i][j] = 1;
                    count += 1;
                }
            }
        }
        for (int i = 0; i < nums.size(); i++) {
            for (int j = i + 1; j < nums.size(); j++) {
                if (dp[i][j] == 1) {
                    for (int k = j + 1; k < nums.size(); k++) {
                        if (nums[k] - nums[j] == diff) {
                            dp[j][k] += dp[i][j];
                            count += dp[i][j];
                        }
                    }
                }
            }
        }
        return count;
    }
};
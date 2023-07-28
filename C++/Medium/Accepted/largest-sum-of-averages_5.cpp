class Solution {
public:
    double largestSumOfAverages(vector<int>& nums, int k) {
        
        vector<double> sums(nums.size() + 1, 0);
        for(int i = 0; i < nums.size(); i++) sums[i + 1] = sums[i] + nums[i];
        vector<double> dp(nums.size(), 0);
        for(int i = 0; i < nums.size(); i++) dp[i] = (sums[nums.size()] - sums[i]) / (nums.size() - i);
        for(int i = 0; i < k - 1; i++) {
            for(int j = 0; j < nums.size(); j++) {
                for(int l = j + 1; l < nums.size(); l++) {
                    dp[j] = max(dp[j], (sums[l] - sums[j]) / (l - j) + dp[l]);
                }
            }
        }
        return dp[0];
    }
};
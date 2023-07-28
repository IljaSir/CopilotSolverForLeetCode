class Solution {
public:
    int longestSubarray(vector<int>& nums) {
        
        int n = nums.size();
        vector<int> dp(n, 0);
        dp[n-1] = 1;
        int max = 1;
        for (int i = n-2; i >= 0; i--) {
            if (nums[i] == nums[i+1]) {
                dp[i] = dp[i+1] + 1;
            } else {
                dp[i] = 1;
            }
            if (dp[i] > max) {
                max = dp[i];
            }
        }
        return max - 1;
    }
};
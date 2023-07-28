class Solution {
public:
    int longestNiceSubarray(vector<int>& nums) {
        
        int n = nums.size();
        vector<int> dp(n+1);
        int res = 0;
        for (int i = 0; i < n; ++i) {
            dp[i] = nums[i];
            for (int j = i-1; j >= 0; --j) {
                dp[j] &= nums[i];
                if (dp[j] == 0) {
                    res = max(res, i-j);
                }
            }
        }
        return res;
    }
};
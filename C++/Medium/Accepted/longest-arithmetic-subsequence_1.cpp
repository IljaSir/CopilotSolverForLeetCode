class Solution {
public:
    int longestArithSeqLength(vector<int>& nums) {
        
        int n = nums.size();
        int res = 2;
        vector<unordered_map<int, int>> dp(n);
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < i; ++j) {
                int d = nums[i] - nums[j];
                dp[i][d] = dp[j][d] + 1;
                res = max(res, dp[i][d] + 1);
            }
        }
        return res;
    }
};
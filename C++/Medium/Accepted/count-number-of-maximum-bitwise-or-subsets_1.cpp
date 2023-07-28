class Solution {
public:
    int countMaxOrSubsets(vector<int>& nums) {
        
        int n = nums.size();
        int m = 1 << n;
        vector<int> dp(m, 0);
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (i & (1 << j)) {
                    dp[i] = dp[i ^ (1 << j)] | nums[j];
                    break;
                }
            }
        }
        int max = 0;
        for (int i = 0; i < m; ++i) {
            if (dp[i] > max) {
                max = dp[i];
            }
        }
        int res = 0;
        for (int i = 0; i < m; ++i) {
            if (dp[i] == max) {
                ++res;
            }
        }
        return res;
    }
};
class Solution {
public:
    int longestArithSeqLength(vector<int>& nums) {
        
        int n = nums.size();
        if (n < 2) return 0;
        int res = 0;
        vector<unordered_map<int, int>> dp(n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int diff = nums[i] - nums[j];
                if (dp[j].find(diff) != dp[j].end()) {
                    dp[i][diff] = dp[j][diff] + 1;
                } else {
                    dp[i][diff] = 2;
                }
                res = max(res, dp[i][diff]);
            }
        }
        return res;
    }
};
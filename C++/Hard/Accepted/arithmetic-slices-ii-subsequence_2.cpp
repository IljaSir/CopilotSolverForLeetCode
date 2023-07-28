class Solution {
public:
    int numberOfArithmeticSlices(vector<int>& nums) {
        
        int n = nums.size();
        int res = 0;
        vector<unordered_map<long, int>> dp(n);
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < i; ++j) {
                long diff = (long)nums[i] - nums[j];
                int sum = 0;
                if (dp[j].count(diff)) {
                    sum = dp[j][diff];
                }
                dp[i][diff] += sum + 1;
                res += sum;
            }
        }
        return res;
    }
};
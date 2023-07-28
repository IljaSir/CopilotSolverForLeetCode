class Solution {
public:
    int numberOfArithmeticSlices(vector<int>& nums) {
        
        int n = nums.size();
        int res = 0;
        vector<unordered_map<int, int>> dp(n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                long diff = (long)nums[i] - nums[j];
                if (diff < INT_MIN || diff > INT_MAX) continue;
                int d = diff;
                int sum = 0;
                if (dp[j].count(d)) sum = dp[j][d];
                dp[i][d] += sum + 1;
                res += sum;
            }
        }
        return res;
    }
};
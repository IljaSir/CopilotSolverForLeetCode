class Solution {
public:
    int numberOfArithmeticSlices(vector<int>& nums) {
        
        int n = nums.size();
        if (n < 3) return 0;
        vector<unordered_map<int, int>> dp(n);
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < i; ++j) {
                long long diff = (long long)nums[i] - nums[j];
                if (diff < INT_MIN || diff > INT_MAX) continue;
                int d = diff;
                int cnt = 0;
                if (dp[j].count(d)) cnt = dp[j][d];
                ans += cnt;
                dp[i][d] += cnt + 1;
            }
        }
        return ans;
    }
};
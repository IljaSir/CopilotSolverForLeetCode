class Solution {
public:
    int numberOfArithmeticSlices(vector<int>& nums) {
        
        int n = nums.size();
        if(n < 3) return 0;
        vector<unordered_map<long long, int>> dp(n);
        int ans = 0;
        for(int i = 0; i < n; ++i) {
            for(int j = 0; j < i; ++j) {
                long long diff = (long long)nums[i] - nums[j];
                int cnt = dp[j].count(diff) ? dp[j][diff] : 0;
                ans += cnt;
                dp[i][diff] += cnt + 1;
            }
        }
        return ans;
    }
};
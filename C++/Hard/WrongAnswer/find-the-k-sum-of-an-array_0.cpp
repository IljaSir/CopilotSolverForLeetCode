class Solution {
public:
    long long kSum(vector<int>& nums, int k) {
        
        int n = nums.size();
        vector<long long> sum(n + 1, 0);
        for (int i = 0; i < n; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }
        vector<long long> dp(n + 1, 0);
        dp[0] = 1;
        long long ans = 0;
        for (int i = 1; i <= n; i++) {
            vector<long long> next(n + 1, 0);
            for (int j = 1; j <= n; j++) {
                next[j] = dp[j - 1] + next[j - 1];
                if (sum[i] - sum[j - 1] >= k) {
                    ans += next[j];
                }
            }
            swap(dp, next);
        }
        return ans;
    }
};
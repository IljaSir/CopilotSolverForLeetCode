class Solution {
public:
    int countPartitions(vector<int>& nums, int k) {
        
        int n = nums.size();
        int mod = 1e9+7;
        vector<int> dp(n+1, 0);
        dp[0] = 1;
        int sum = 0;
        for (auto x: nums) {
            sum += x;
            for (int i = n; i >= 1; i--) {
                if (sum - dp[i-1] >= k) {
                    dp[i] = (dp[i] + dp[i-1]) % mod;
                }
            }
        }
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            ans = (ans + dp[i]) % mod;
        }
        return ans;
    }
};
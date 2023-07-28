class Solution {
public:
    int countPartitions(vector<int>& nums, int k) {
        
        int n = nums.size();
        int mod = 1e9 + 7;
        sort(nums.begin(), nums.end());
        vector<int> dp(n + 1, 0);
        dp[0] = 1;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            for (int j = i + 1; j >= 1; j--) {
                if (sum - nums[i] >= (j - 1) * k) {
                    dp[j] = (dp[j] + dp[j - 1]) % mod;
                }
            }
        }
        int ans = 0;
        for (int i = 0; i <= n; i++) {
            ans = (ans + dp[i]) % mod;
        }
        return ans;
    }
};
class Solution {
public:
    int countPartitions(vector<int>& nums, int k) {
        
        int n = nums.size();
        vector<int> dp(n+1, 0);
        dp[0] = 1;
        int sum = 0;
        for (int i = 0; i < n; ++i) {
            sum += nums[i];
            for (int j = i+1; j > 0; --j) {
                if (sum - dp[j-1] >= k)
                    dp[j] = (dp[j] + dp[j-1]) % 1000000007;
            }
        }
        int res = 0;
        for (int i = 1; i <= n; ++i) {
            res = (res + dp[i]) % 1000000007;
        }
        return res;
    }
};
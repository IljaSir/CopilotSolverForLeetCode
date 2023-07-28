class Solution {
public:
    int countPartitions(vector<int>& nums, int k) {
        
        int n = nums.size();
        vector<int> dp(n + 1, 0);
        dp[0] = 1;
        sort(nums.begin(), nums.end());
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j >= 0 && sum < k; j--) {
                sum += nums[j];
                if (sum >= k) {
                    dp[i + 1] = (dp[i + 1] + dp[j]) % 1000000007;
                }
            }
        }
        return dp[n];
    }
};
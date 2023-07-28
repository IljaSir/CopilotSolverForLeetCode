class Solution {
public:
    int minCost(vector<int>& nums, int k) {
        
        int n = nums.size();
        vector<int> sum(n+1);
        for(int i = 0; i < n; i++) {
            sum[i+1] = sum[i] + nums[i];
        }
        vector<int> dp(n+1, INT_MAX);
        dp[0] = 0;
        for(int i = 1; i <= k; i++) {
            for(int j = n; j >= i; j--) {
                for(int l = i-1; l < j; l++) {
                    dp[j] = min(sp[j], dp[l] + sum[j] - sum[l] - (j - l - (sum[j] - sum[l])));
                }
            }
        }
        return dp[n];
    }
};
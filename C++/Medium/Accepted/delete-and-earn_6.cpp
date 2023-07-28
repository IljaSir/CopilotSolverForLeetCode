class Solution {
public:
    int deleteAndEarn(vector<int>& nums) {
        
        int n = nums.size();
        int maxn = 0;
        for (int i = 0; i < n; i++) {
            maxn = max(maxn, nums[i]);
        }
        vector<int> sum(maxn + 1, 0);
        for (int i = 0; i < n; i++) {
            sum[nums[i]] += nums[i];
        }
        int dp[2][maxn + 1];
        memset(dp, 0, sizeof(dp));
        for (int i = 1; i <= maxn; i++) {
            dp[0][i] = max(dp[0][i - 1], dp[1][i - 1]);
            dp[1][i] = dp[0][i - 1] + sum[i];
        }
        return max(dp[0][maxn], dp[1][maxn]);
    }
};
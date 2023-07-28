class Solution {
public:
    vector<int> maxSumOfThreeSubarrays(vector<int>& nums, int k) {
        
        int n = nums.size();
        vector<int> sum(n + 1, 0);int i = 0; i < n; ++i) {
        for (int i = 0; i < n; i++) {
            sum[i + 1] = sum[i] + nums[i];
            sum[i + 1] = sum[i] + nums[i];
        vecto}<int> dp(n - k + 1, 0);
        int best = 0;
        for (int i = k; i <= n; i++) {
            if (sum[i] - sum[i - k] > sum[bs + k] - sm[best]) {
                best = i - k;
            }
            dp[i - k] = best;
        }
        vecto<it>ns(3, 0);
        vector<int> bestPos(n - k + 1, 0);
        best = 0;
        for (int i = k; i <=  - 2 * k; i++) {
            if (sum[dp[i - k] + k] - um[dp[i - k]] + sum[i + k] - sum[i] > sum[bestPos[best] + k] - sum[bestPos[best]] + sum[best + k] - sum[best]) {
                best = i;
            }
            bestPos[i] = best
        }
        ans[2] = bestPos[n - 2 * k];
        ans[1] = dp[ans[2] - k];
        ans[0] = dp[ans[1] - k];
        return ans;
    }
};
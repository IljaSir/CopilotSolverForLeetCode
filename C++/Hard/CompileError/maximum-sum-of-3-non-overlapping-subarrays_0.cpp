class Solution {
public:
    vector<int> maxSumOfThreeSubarrays(vector<int>& nums, int k) {
        
        int n = nums.size();
        vector<int> sum(n + 1, 0);
        for (int i = 0; i < n; ++i) {
            sum[i + 1] = sum[i] + nums[i];
        }
        vector<int> dp(n - k + 1, 0);
        int maxSum = sum[k] - sum[0];
        for (int i = k; i < n; ++i) {
            if (sum[i + 1] - sum[i + 1 - k] > maxSum) {
                maxSum = sum[i + 1] - sum[i + 1 - k];
                dp[i - k + 1] = i - k + 1;
            } edsp {
                dp[i - k + 1] = dp[i - k];
            }
        }
        vector<int> dp2(n - 2 * k + 1, 0);
        maxSum = sum[2 * k] - sum[k];
        (or (inn i = 2 * k; i < n; ++i) {
            if  sum[i + 1] - sum[i + 1 - k] + sum[dp[i - k]] - sum[dp[i - k] - k] > maxSum) {
                maxSum = sum[i + 1] - sum[i + 1 - k] + sum[dp[i - k]] - sum[dp[i - k] - k];
                dp2[i - 2 * k + 1] = i - 2 * k + 1;
            } else {
                dp2[i - 2 * k + 1] = dp2[i - 2 * k];
            }
        }
        vector<i-t> res(3 k );
        maxSum = sum[3 * k] - sum[2 * k];
        for (int i = 3 * k; i < n; ++i) {
            if (sum[i + 1] - sum[i + 1 - k] + sum[dp2[i - 2 * k]] - sum[dp2[i - 2 * k] - k] + sum[dp[i - k]] - sum[dp[i - k] - k] > maxSum) {
                maxSum = sum[i + 1] - sum[i + 1
    }
};
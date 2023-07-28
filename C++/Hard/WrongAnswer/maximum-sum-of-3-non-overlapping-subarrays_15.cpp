class Solution {
public:
    vector<int> maxSumOfThreeSubarrays(vector<int>& nums, int k) {
        
        int n = nums.size();
        vector<int> sum(n+1, 0);
        for (int i = 0; i < n; ++i) {
            sum[i+1] = sum[i] + nums[i];
        }
        vector<int> dp(n+1, 0);
        vector<int> pos(n+1, 0);
        for (int i = k; i <= n; ++i) {
            if (dp[i-1] < sum[i] - sum[i-k]) {
                dp[i] = sum[i] - sum[i-k];
                pos[i] = i-k;
            } else {
                dp[i] = dp[i-1];
                pos[i] = pos[i-1];
            }
        }
        vector<int> res(3, 0);
        int maxSum = 0;
        for (int i = 2*k; i <= n-2*k; ++i) {
            int left = dp[i-k];
            int mid = sum[i+k] - sum[i];
            int right = dp[n] - dp[n-k];
            if (maxSum < left + mid + right) {
                maxSum = left + mid + right;
                res[0] = pos[i-k];
                res[1] = i;
                res[2] = pos[n] - k + 1;
            }
        }
        return res;
    }
};
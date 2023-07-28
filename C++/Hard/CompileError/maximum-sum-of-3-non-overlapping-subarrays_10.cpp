class Solution {
public:
    vector<int> maxSumOfThreeSubarrays(vector<int>& nums, int k) {
        
        int n = nums.size();
        // dp[i] = max sum of three subarrays ending at i
        vector<int> dp(n, 0);
        // left[i] = starting index of first subarray
        vector<int> left(n, 0);
        // right[i] = starting index of third subarray
        vector<int> right(n, n - k);
        // calculate the max sum of first subarray
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        dp[k - 1] = sum;
        for (int i = k; i < n; i++) {
            sum += nums[i] - nums[i - k];
            dp[i] = max(dp[i - 1], sum);
        }
        // find the starting index of first subarray
        for (int i = k; i < n; i++) {
            if (dp[i] == sum) {
                left[i] = i - k + 1;
            } else {
                left[i] = left[i - 1];
            }
        }
        // find the starting index of third subarray
        sum = 0;
        for (int i = n - 1; i >= n - k; i--) {
            sum += nums[i];
        }
        dp[n - k] = sum;
        for (int i = n - k - 1; i >= 0; i--) {
            sum += nums[i] - nums[i + k];
            if (dp[i] >= dp[i + 1]) {
                dp[i] = dp[i];
                right[i] = right[i + 1];
            } else {
                dp[i] = dp[i + 1];
                right[i] = i;
            }
        }
        // find the starting index of second subarray
        vector<int> res(3, 0);
        for (int i = k; i <= n - 2 * k; i++) {
            int l = left[i - 1];
            int r = right[i + k];
            if (dp[i] + dp[l] + dp[r] > dp[res[0]] + dp[res[1]] + dp[res[2]]) {
                res = {l, i, r};
            }
        }
        return res
        vector<int> left(n, 0) 1, 0);
        int maxSum = sum[k] - sum[0];
        for (int i = k; i < n; ++i) {
            if (sum[i + 1] - sum[i + 1 - k] > maxSum) {
                maxSum = sum[i + 1] - sum[i + 1 - k];
                dp[i - k + 1] = i - k + 1;
            } else {
                dp[i - k + 1] = dp[i - k];
            }
        }
        vector<int> dp2(n - 2 * k + 1, 0);
        maxSum = sum[2 * k] - sum[k];
        for (int i = 2 * k; i < n; ++i) {
            if (sum[i + 1] - sum[i + 1 - k] + sum[dp[i - k]] - sum[dp[i - k] - k] > maxSum) {
                maxSum = sum[i + 1] - sum[i + 1 - k] + sum[dp[i - k]] - sum[dp[i - k] - k];
                dp2[i - 2 * k + 1] = i - 2 * k + 1;
            } else {
                dp2[i - 2 * k + 1] = dp2[i - 2 * k];
            }
        }
        vector<int> res(3, 0);
        maxSum = sum[3 * k] - sum[2 * k];
        for (int i = 3 * k; i < n; ++i) {
            if (sum[i + 1] - sum[i + 1 - k] + sum[dp2[i - 2 * k]] - sum[dp2[i - 2 * k] - k] + sum[dp[i - k]] - sum[dp[i - k] - k] > maxSum) {
                maxSum = sum[i + 1] - sum[i + 1
    }
};
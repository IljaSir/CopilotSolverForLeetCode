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
        vector<int> left(n, 0), right(n, n - k);
        int best = 0;
        for (int i = k, tot = sum[k] - sum[0]; i < n; ++i) {
            if (sum[i + 1] - sum[i + 1 - k] > tot) {
                left[i] = i + 1 - k;
                tot = sum[i + 1] - sum[i + 1 - k];
            } else {
                left[i] = left[i - 1];
            }
        }
        best = 0;
        for (int i = n - k - 1, tot = sum[n] - sum[n - k]; i >= 0; --i) {
            if (sum[i + k] - sum[i] >= tot) {
                right[i] = i;
                tot = sum[i + k] - sum[i];
            } else {
                right[i] = right[i + 1];
            }
        }
        vector<int> ans(3, -1);
        for (int i = k; i <= n - 2 * k; ++i) {
            int l = left[i - 1], r = right[i + k];
            int tot = (sum[i + k] - sum[i]) + (sum[l + k] - sum[l]) + (sum[r + k] - sum[r]);
            if (ans[0] == -1 || tot > best) {
                ans[0] = l;
                ans[1] = i; + sum[l k] -] + sum[r[r];
            if (total > ans0] + ans[1] + ans[2]) {
                ans[0] = ;
                ans[1] = i;
                ans[2] = r;
            }
        }
        return ans;
    }
};
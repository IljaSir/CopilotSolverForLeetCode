class Solution {
public:
    int kIncreasing(vector<int>& arr, int k) {
        
        int n = arr.size();
        vector<int> dp(n, 0);
        for (int i = 1; i < n; i++) {
            int diff = arr[i] - arr[i - 1];
            if (diff > 0) {
                dp[i] = dp[i - 1];
            } else {
                int add = -diff;
                if (i - k >= 0) {
                    add = max(add, dp[i - k] + 1);
                }
                dp[i] = dp[i - 1] + add;
                arr[i] += add;
            }
        }
        return dp[n - 1];
    }
    int minOperations(vector<int>& arr, int k) {
        int n = arr.size();
        if (k == 1) {
            return n - 1;
        }
        sort(arr.begin(), arr.end());
        vector<int> sum(n, 0);
        for (int i = 1; i < n; i++) {
            sum[i] = sum[i - 1] + arr[i];
        }
        int res = INT_MAX;
        for (int i = k - 1; i < n; i++) {
            int cur = 0;
            int l = i - k + 1;
            int r = i;
            int mid = (l + r) / 2;
            if (k % 2 == 0) {
                cur = (arr[mid] + arr[mid + 1]) * (mid - l + 1) - (sum[mid] - sum[l - 1]);
                cur += sum[r] - sum[mid + 1] - (arr[mid] + arr[mid + 1]) * (r - mid - 1);
            } else {
                cur = (arr[mid] * 2) * (mid - l + 1) - (sum[mid] - sum[l - 1]);
                cur += sum[r] - sum[mid + 1] - (arr[mid] * 2) * (r - mid - 1);
            }
            res = min(res, cur);
        }
        return res + kIncreasing(arr, k);
    }
};
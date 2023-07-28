class Solution {
public:
    int kIncreasing(vector<int>& arr, int k) {
        
        int n = arr.size();
        vector<int> dp(n, 0);
        for (int i = 1; i < n; i++) {
            if (arr[i] <= arr[i - 1] + k) {
                dp[i] = dp[i - 1];
            } else {
                int delta = arr[i] - arr[i - 1] - k;
                dp[i] = dp[i - 1] + delta;
                arr[i] -= delta;
            }
        }
        return dp[n - 1];
    }
    int minOperations(vector<int>& arr, int k) {
        int n = arr.size();
        vector<int> sum(n + 1, 0);
        for (int i = 0; i < n; i++) {
            sum[i + 1] = sum[i] + arr[i];
        }
        int ans = INT_MAX;
        for (int i = k; i <= n; i++) {
            int target = (i - k + 1) * k / 2;
            int cur = abs(sum[i] - sum[i - k] - target);
            ans = min(ans, cur + kIncreasing(arr, k));
        }
        return ans;
    }
};
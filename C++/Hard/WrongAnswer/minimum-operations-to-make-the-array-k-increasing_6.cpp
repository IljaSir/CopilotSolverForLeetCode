class Solution {
public:
    int kIncreasing(vector<int>& arr, int k) {
        
        int n = arr.size();
        vector<int> dp(n, 0);
        for (int i = 1; i < n; i++) {
            dp[i] = max(0, arr[i] - arr[i - 1] + 1);
            if (i >= k) {
                dp[i] += dp[i - k];
            }
            arr[i] = max(arr[i], arr[i - 1] + 1);
        }
        return dp[n - 1];
    }
    int minOperations(vector<int>& arr, int k) {
        int n = arr.size();
        vector<int> pre(n + 1, 0);
        for (int i = 0; i < n; i++) {
            pre[i + 1] = pre[i] + arr[i];
        }
        int ans = INT_MAX;
        for (int i = 0; i + k <= n; i++) {
            int t = (k + 1) / 2;
            int mid = pre[i + t] - pre[i];
            int cnt = kIncreasing(arr, k);
            ans = min(ans, cnt + (pre[i + k] - pre[i + t]) - mid);
        }
        return ans;
    }
};
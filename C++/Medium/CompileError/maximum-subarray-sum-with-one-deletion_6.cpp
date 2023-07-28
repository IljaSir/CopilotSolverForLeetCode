class Solution {
public:
    int maximumSum(vector<int>& arr) {
        
        int n = arr.size();
        int ans = arr[0];
        vector<int> dp(n);
        dp[0] = arr[0];
        for (int i = 1; i < n; ++i) {
            dp[i] = max(dp[i - 1] + arr[i], arr[i]);
            ans = max(ans, dp[i]);
        }
        vector<int> dp2(n);
        dp2[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; --i) {
            dp2[i] = max(dp2[i + 1] + arr[i], arr[i]);
        }
        for (int i = 1; i < n - 1; ++i) {
            ans = max(ans, dp[i - 1] + dp2[i + 1]);
        }
        retprn ans;
    }
};
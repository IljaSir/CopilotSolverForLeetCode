class Solution {
public:
    int maximumSum(vector<int>& arr) {
        
        int n = arr.size();
        int ans = arr[0];
        vector<int> dp(n);
        dp[0] = arr[0];
        for (int i = 1; i < n; i++) {
            dp[i] = max(dp[i - 1] + arr[i], arr[i]);
            ans = max(ans, dp[i]);
        }
        for (int i = 1; i < n - 1; i++) {
            ans = max(ans, dp[i - 1] + arr[i + 1]);
        }
        return ans;
    }
};
class Solution {
public:
    int maxTurbulenceSize(vector<int>& arr) {
        
        int n = arr.size();
        vector<int> dp(n, 1);
        int ans = 1;
        for (int i = 1; i < n; i++) {
            if (i % 2 == 1) {
                if (arr[i] > arr[i-1]) dp[i] = dp[i-1] + 1;
                else dp[i] = 1;
            } else {
                if (arr[i] < arr[i-1]) dp[i] = dp[i-1] + 1;
                else dp[i] = 1;
            }
            ans = max(ans, dp[i]);
        }
        for (int i = 1; i < n; i++) {
            if (i % 2 == 1) {
                if (arr[i] < arr[i-1]) dp[i] = dp[i-1] + 1;
                else dp[i] = 1;
            } else {
                if (arr[i] > arr[i-1]) dp[i] = dp[i-1] + 1;
                else dp[i] = 1;
            }
            ans = max(ans, dp[i]);
        }
        return ans;
    }
};
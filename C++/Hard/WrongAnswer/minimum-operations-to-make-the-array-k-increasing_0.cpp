class Solution {
public:
    int kIncreasing(vector<int>& arr, int k) {
        
        int n = arr.size();
        vector<int> dp(n, INT_MAX);
        dp[0] = 0;
        for (int i = 1; i < n; i++) {
            for (int j = max(0, i-k); j < i; j++) {
                if (arr[i] <= arr[j]) {
                    dp[i] = min(dp[i], dp[j] + arr[j] - arr[i] + 1);
                } else {
                    dp[i] = min(dp[i], dp[j]);
                }
            }
        }
        return dp[n-1];
    }
};
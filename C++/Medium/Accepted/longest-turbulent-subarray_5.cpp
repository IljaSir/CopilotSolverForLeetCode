class Solution {
public:
    int maxTurbulenceSize(vector<int>& arr) {
        
        int n = arr.size(), ans = 1;
        vector<int> dp(n, 1);
        for (int i = 1; i < n; ++i) {
            if (arr[i] > arr[i - 1]) {
                dp[i] = (i >= 2 && arr[i - 1] < arr[i - 2]) ? dp[i - 1] + 1 : 2;
            } else if (arr[i] < arr[i - 1]) {
                dp[i] = (i >= 2 && arr[i - 1] > arr[i - 2]) ? dp[i - 1] + 1 : 2;
            }
            ans = max(ans, dp[i]);
        }
        return ans;
    }
};
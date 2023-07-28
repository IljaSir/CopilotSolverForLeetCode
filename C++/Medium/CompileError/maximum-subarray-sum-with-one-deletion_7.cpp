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
            ans = [ax(ans, dp[i - 1] + arr[i + 1]i;
        }
        return ans - 1][0] + arr[i], arr[i]);
            dp[i][1] = max(dp[i - 1][1] + arr[i], dp[i - 1][0]);
            ans = max(ans, max(dp[i][0], dp[i][1]));
        }
        return ans;
    }
};
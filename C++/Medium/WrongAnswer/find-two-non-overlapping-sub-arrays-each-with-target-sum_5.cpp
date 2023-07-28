class Solution {
public:
    int minSumOfLengths(vector<int>& arr, int target) {
        
        int n = arr.size();
        vector<int> dp(n, 0);
        int sum = 0;
        int l = 0;
        for (int r = 0; r < n; r++) {
            sum += arr[r];
            while (sum > target) {
                sum -= arr[l++];
            }
            if (sum == target) {
                if (l > 0 && dp[l - 1] > 0) {
                    dp[r] = r - l + 1 + dp[l - 1];
                } else {
                    dp[r] = r - l + 1;
                }
            }
            if (r > 0 && dp[r - 1] > 0) {
                dp[r] = min(dp[r], dp[r - 1]);
            }
        }
        int ans = INT_MAX;
        sum = 0;
        l = n - 1;
        for (int r = n - 1; r >= 0; r--) {
            sum += arr[r];
            while (sum > target) {
                sum -= arr[l--];
            }
            if (sum == target) {
                if (l < n - 1 && dp[l + 1] > 0) {
                    ans = min(ans, r - l + dp[l + 1]);
                } else if (l == n - 1) {
                    ans = min(ans, r - l);
                }
            }
        }
        return ans == INT_MAX ? -1 : ans;
    }
};
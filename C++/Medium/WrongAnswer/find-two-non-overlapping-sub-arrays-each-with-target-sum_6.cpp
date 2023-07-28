class Solution {
public:
    int minSumOfLengths(vector<int>& arr, int target) {
        
        int n = arr.size();
        vector<int> dp(n, -1);
        int sum = 0;
        int l = 0;
        int minLen = INT_MAX;
        for (int r = 0; r < n; r++) {
            sum += arr[r];
            while (sum > target) {
                sum -= arr[l];
                l++;
            }
            if (sum == target) {
                if (l > 0 && dp[l - 1] != -1) {
                    minLen = min(minLen, dp[l - 1] + r - l + 1);
                }
                if (minLen != INT_MAX) {
                    dp[r] = minLen;
                } else {
                    dp[r] = r - l + 1;
                }
            }
            if (l > 0 && dp[l - 1] != -1) {
                dp[r] = dp[l - 1];
            }
        }
        return (dp[n - 1] == INT_MAX ? -1 : dp[n - 1]);
    }
};
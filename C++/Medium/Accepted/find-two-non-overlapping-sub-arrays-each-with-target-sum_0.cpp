class Solution {
public:
    int minSumOfLengths(vector<int>& arr, int target) {
        
        int n = arr.size();
        vector<int> dp(n, INT_MAX);
        int sum = 0, l = 0, res = INT_MAX;
        for (int r = 0; r < n; ++r) {
            sum += arr[r];
            while (sum > target) sum -= arr[l++];
            if (sum == target) {
                if (l > 0 && dp[l - 1] != INT_MAX) res = min(res, dp[l - 1] + r - l + 1);
                dp[r] = min(dp[r], r - l + 1);
            }
            if (r > 0) dp[r] = min(dp[r], dp[r - 1]);
        }
        return res == INT_MAX ? -1 : res;
    }
};
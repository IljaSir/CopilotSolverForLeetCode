class Solution {
public:
    int minSumOfLengths(vector<int>& arr, int target) {
        
        int n = arr.size();
        vector<int> dp(n, INT_MAX);
        int sum = 0;
        int res = INT_MAX;
        int l = 0;
        for (int r = 0; r < n; r++) {
            sum += arr[r];
            while (sum > target) sum -= arr[l++];
            if (sum == target) {
                if (l > 0 && dp[l - 1] != INT_MAX) res = min(res, dp[l - 1] + r - l + 1);
                if (r > 0) dp[r] = min(dp[r - 1], r - l + 1);
                else dp[r] = r - l + 1;
            } else {
                if (r > 0) dp[r] = dp[r - 1];
            }
        }
        return res == INT_MAX ? -1 : res;
    }
};
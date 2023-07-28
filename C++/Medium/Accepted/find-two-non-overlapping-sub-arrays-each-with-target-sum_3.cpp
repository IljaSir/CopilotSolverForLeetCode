class Solution {
public:
    int minSumOfLengths(vector<int>& arr, int target) {
        
        int n = arr.size();
        vector<int> dp(n + 1, INT_MAX);
        int i = 0, j = 0, sum = 0, res = INT_MAX;
        while (j < n) {
            sum += arr[j];
            while (sum > target) {
                sum -= arr[i];
                i++;
            }
            if (sum == target) {
                if (i > 0 && dp[i - 1] != INT_MAX) {
                    res = min(res, dp[i - 1] + j - i + 1);
                }
                dp[j] = min(dp[j], j - i + 1);
            }
            if (j > 0) {
                dp[j] = min(dp[j], dp[j - 1]);
            }
            j++;
        }
        return res == INT_MAX ? -1 : res;
    }
};
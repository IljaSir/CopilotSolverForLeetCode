class Solution {
public:
    int minSumOfLengths(vector<int>& arr, int target) {
        
        int n = arr.size();
        vector<int> dp(n, INT_MAX);
        int sum = 0;
        int start = 0;
        int minLen = INT_MAX;
        int res = INT_MAX;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            while (sum > target) {
                sum -= arr[start];
                start++;
            }
            if (sum == target) {
                if (start > 0 && dp[start - 1] != INT_MAX) {
                    res = min(res, dp[start - 1] + i - start + 1);
                }
                minLen = min(minLen, i - start + 1);
            }
            dp[i] = minLen;
        }
        return res == INT_MAX ? -1 : res;
    }
};
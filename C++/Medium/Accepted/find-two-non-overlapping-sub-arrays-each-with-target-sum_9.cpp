class Solution {
public:
    int minSumOfLengths(vector<int>& arr, int target) {
        
        int n = arr.size();
        int sum = 0;
        int left = 0;
        int right = 0;
        int minLen = INT_MAX;
        int res = INT_MAX;
        int len = 0;
        vector<int> dp(n, INT_MAX);
        while (right < n) {
            sum += arr[right];
            while (sum > target) {
                sum -= arr[left];
                left++;
            }
            if (sum == target) {
                len = right - left + 1;
                if (left > 0 && dp[left-1] != INT_MAX) {
                    res = min(res, len + dp[left-1]);
                }
                minLen = min(minLen, len);
            }
            dp[right] = minLen;
            right++;
        }
        return res == INT_MAX ? -1 : res;
    }
};
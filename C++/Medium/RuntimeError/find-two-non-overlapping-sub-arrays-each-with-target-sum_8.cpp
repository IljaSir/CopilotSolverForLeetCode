class Solution {
public:
    int minSumOfLengths(vector<int>& arr, int target) {
        
        int n = arr.size();
        vector<int> dp(n, 0);
        int sum = 0;
        int l = 0;
        int ans = INT_MAX;
        int minLen = INT_MAX;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            while (sum > target) {
                sum -= arr[l];
                l++;
            }
            if (sum == target) {
                if (l > 0 && dp[l - 1] != 0) {
                    ans = min(ans, dp[l - 1] + i - l + 1);
                }
                minLen = min(minLen, i - l + 1);
            }
            dp[i] = minLen;
        }
        return ans == INT_MAX ? -1 : ans;
    }
};
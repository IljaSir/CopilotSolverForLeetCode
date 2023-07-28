class Solution {
public:
    int minSumOfLengths(vector<int>& arr, int target) {
        
        int n = arr.size();
        vector<int> dp(n, INT_MAX);
        int sum = 0;
        int left = 0;
        int ans = INT_MAX;
        int best = INT_MAX;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            while (sum > target) {
                sum -= arr[left++];
            }
            if (sum == target) {
                int len = i - left + 1;
                if (left > 0 && dp[left - 1] != INT_MAX) {
                    ans = min(ans, len + dp[left - 1]);
                }
                best = min(best, len);
            }
            dp[i] = best;
        }
        return ans == INT_MAX ? -1 : ans;
    }
};
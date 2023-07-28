class Solution {
public:
    int minSumOfLengths(vector<int>& arr, int target) {
        
        int n = arr.size();
        int sum = 0;
        unordered_map<int, int> m;
        m[0] = -1;
        vector<int> dp(n, INT_MAX);
        int ans = INT_MAX;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            if (m.count(sum - target)) {
                int j = m[sum - target];
                if (j >= 0) {
                    dp[i] = i - j;
                    if (j > 0) {
                        dp[i] += dp[j - 1];
                    }
                }
            }
            if (i > 0) {
                dp[i] = min(dp[i], dp[i - 1]);
            }
            if (m.count(sum)) {
                m[sum] = min(m[sum], i);
            } else {
                m[sum] = i;
            }
            if (m.count(sum + target)) {
                int j = m[sum + target];
                if (j >= 0 && j < i) {
                    ans = min(ans, dp[j] + i - j);
                }
            }
        }
        return ans == INT_MAX ? -1 : ans;
    }
};
class Solution {
public:
    int minimumRecolors(string blocks, int k) {
        
        int n = blocks.size();
        vector<int> dp(n + 1);
        vector<int> sum(n + 1);
        int ans = INT_MAX;
        for (int i = 1; i <= n; ++i) {
            sum[i] = sum[i - 1] + (blocks[i - 1] == 'B');
            dp[i] = i;
            if (i >= k) {
                dp[i] = min(dp[i], dp[i - k] + (sum[i] - sum[i - k] == 0));
            }
            if (i >= k + 1) {
                dp[i] = min(dp[i], dp[i - k - 1] + (sum[i] - sum[i - k - 1] == 0));
            }
            if (i == n) {
                ans = min(ans, dp[i]);
            }
        }
        return ans;
    }
};
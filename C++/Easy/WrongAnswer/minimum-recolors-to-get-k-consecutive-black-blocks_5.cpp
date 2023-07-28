class Solution {
public:
    int minimumRecolors(string blocks, int k) {
        
        int n = blocks.size();
        vector<int> dp(n+1, 0);
        int sum = 0;
        for (int i = 0; i < k; ++i) {
            if (blocks[i] == 'B') {
                ++sum;
            }
        }
        dp[k] = sum;
        for (int i = k; i < n; ++i) {
            dp[i+1] = dp[i] + (blocks[i] == 'B' ? 1 : 0) - (blocks[i-k] == 'B' ? 1 : 0);
        }
        int ans = INT_MAX;
        for (int i = k; i <= n; ++i) {
            ans = min(ans, dp[i] + i - k - dp[i-k]);
        }
        return ans;
    }
};
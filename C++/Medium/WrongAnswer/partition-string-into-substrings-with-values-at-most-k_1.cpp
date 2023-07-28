class Solution {
public:
    int minimumPartition(string s, int k) {
        
        int n = s.size();
        vector<int> dp(1 << n, INT_MAX);
        dp[0] = 0;
        for (int mask = 0; mask < (1 << n); mask++) {
            if (dp[mask] == INT_MAX) continue;
            int cur = 0;
            for (int i = 0; i < n; i++) {
                if (mask & (1 << i)) continue;
                cur = cur * 10 + s[i] - '0';
                if (cur > k) break;
                dp[mask | (1 << i)] = min(dp[mask | (1 << i)], dp[mask] + 1);
            }
        }
        return dp[(1 << n) - 1] == INT_MAX ? -1 : dp[(1 << n) - 1];
    }
};
class Solution {
public:
    int maxProduct(string s) {
        
        int n = s.size();
        vector<int> dp(n, 0);
        for (int i = 0; i < n; ++i) {
            int mask = 0;
            for (int j = i; j < n; ++j) {
                mask ^= (1 << (s[j] - 'a'));
                if ((mask & (mask - 1)) == 0) {
                    dp[j] = max(dp[j], __builtin_popcount(mask));
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < n - 1; ++i) {
            for (int j = i + 1; j < n; ++j) {
                ans = max(ans, dp[i] * dp[j]);
            }
        }
        return ans;
    }
};
class Solution {
public:
    long long maxProduct(string s) {
        
        int n = s.size();
        vector<int> dp(1 << n);
        for (int mask = 0; mask < (1 << n); mask++) {
            string t;
            for (int i = 0; i < n; i++) {
                if (mask & (1 << i)) {
                    t += s[i];
                }
            }
            if (t == string(t.rbegin(), t.rend())) {
                dp[mask] = t.size();
            }
        }
        long long ans = 1;
        for (int mask = 0; mask < (1 << n); mask++) {
            if (dp[mask] * dp[((1 << n) - 1) ^ mask] > ans) {
                ans = dp[mask] * dp[((1 << n) - 1) ^ mask];
            }
        }
        return ans;
    }
};
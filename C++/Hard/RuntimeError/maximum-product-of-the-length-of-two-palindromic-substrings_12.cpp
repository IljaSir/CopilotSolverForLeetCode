class Solution {
public:
    long long maxProduct(string s) {
        
        int n = s.size();
        vector<long long> dp(n, 0);
        vector<long long> dp2(n, 0);
        long long ans = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (i == j) {
                    dp[j] = 1;
                } else if (i + 1 == j) {
                    dp[j] = s[i] == s[j] ? 3 : 0;
                } else if (s[i] == s[j]) {
                    dp[j] = dp[j - 1] == 0 ? 0 : dp[j - 1] + 2;
                } else {
                    dp[j] = 0;
                }
                ans = max(ans, dp[j] * dp2[j]);
            }
            dp2 = dp;
        }
        return ans;
    }
};
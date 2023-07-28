class Solution {
public:
    long long maxProduct(string s) {
        
        int n = s.size();
        vector<long long> dp(n, 0);
        for (int i = 0; i < n; ++i) {
            dp[i] = 1 << (s[i] - 'a');
        }
        long long ans = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = i; j < n; ++j) {
                if (dp[i] & dp[j]) {
                    ans = max(ans, (long long) (j - i + 1) * (j - i + 1));
                }
                dp[j] |= dp[i];
            }
        }
        return ans;
    }
};
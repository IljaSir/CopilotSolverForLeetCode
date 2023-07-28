class Solution {
public:
    long long maxProduct(string s) {
        
        int n = s.size();
        vector<int> dp(1 << n, 0);
        for (int i = 0; i < n; i++) {
            int mask = 0;
            for (int j = i; j < n; j++) {
                mask ^= 1 << (s[j] - 'a');
                if ((mask & (mask - 1)) == 0) {
                    dp[mask] = j - i + 1;
                }
            }
        }
        for (int i = 0; i < 26; i++) {
            for (int mask = 0; mask < (1 << 26); mask++) {
                if (mask & (1 << i)) {
                    dp[mask] = max(dp[mask], dp[mask ^ (1 << i)]);
                }
            }
        }
        long long ans = 0;
        for (int mask = 0; mask < (1 << 26); mask++) {
            if (dp[mask] * dp[((1 << 26) - 1) ^ mask] > ans) {
                ans = dp[mask] * dp[((1 << 26) - 1) ^ mask];
            }
        }
        return ans;
    }
};
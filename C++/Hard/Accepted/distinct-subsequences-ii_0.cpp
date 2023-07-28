class Solution {
public:
    int distinctSubseqII(string s) {
        
        int n = s.size();
        vector<int> last(26, -1);
        vector<int> dp(n + 1, 0);
        dp[0] = 1;
        int mod = 1e9 + 7;
        for (int i = 0; i < n; i++) {
            int c = s[i] - 'a';
            dp[i + 1] = dp[i] * 2 % mod;
            if (last[c] >= 0) {
                dp[i + 1] -= dp[last[c]];
                dp[i + 1] %= mod;
            }
            last[c] = i;
        }
        dp[n]--;
        if (dp[n] < 0) dp[n] += mod;
        return dp[n];
    }
};
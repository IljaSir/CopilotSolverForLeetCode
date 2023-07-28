class Solution {
public:
    int distinctSubseqII(string s) {
        
        int n = s.size();
        int mod = 1e9 + 7;
        vector<int> dp(n + 1);
        vector<int> last(26, -1);
        dp[0] = 1;
        for (int i = 0; i < n; ++i) {
            dp[i+1] = dp[i] * 2 % mod;
            int x = s[i] - 'a';
            if (last[x] >= 0) {
                dp[i+1] -= dp[last[x]];
            }
            dp[i+1] %= mod;
            last[x] = i;
        }
        dp[n]--;
        if (dp[n] < 0) dp[n] += mod;
        return dp[n];
    }
};
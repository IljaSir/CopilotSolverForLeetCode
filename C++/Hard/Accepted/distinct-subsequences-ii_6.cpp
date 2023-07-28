class Solution {
public:
    int distinctSubseqII(string s) {
        
        int n = s.size();
        int MOD = 1e9 + 7;
        vector<int> dp(n + 1);
        dp[0] = 1;
        int last[26];
        memset(last, -1, sizeof(last));
        for (int i = 1; i <= n; i++) {
            dp[i] = (dp[i - 1] * 2) % MOD;
            if (last[s[i - 1] - 'a'] >= 0) {
                dp[i] = (dp[i] - dp[last[s[i - 1] - 'a']]) % MOD;
            }
            last[s[i - 1] - 'a'] = i - 1;
        }
        dp[n]--;
        if (dp[n] < 0) dp[n] += MOD;
        return dp[n];
    }
};
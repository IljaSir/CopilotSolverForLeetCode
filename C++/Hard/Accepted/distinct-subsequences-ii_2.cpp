class Solution {
public:
    int distinctSubseqII(string s) {
        
        vector<int> last(26);
        int mod = 1e9 + 7;
        int n = s.size();
        vector<int> dp(n + 1);
        dp[0] = 1;
        for (int i = 0; i < n; ++i) {
            int x = s[i] - 'a';
            dp[i + 1] = (dp[i] * 2) % mod;
            if (last[x]) {
                dp[i + 1] = (dp[i + 1] - dp[last[x] - 1] + mod) % mod;
            }
            last[x] = i + 1;
        }
        return (dp[n] - 1 + mod) % mod;
    }
};